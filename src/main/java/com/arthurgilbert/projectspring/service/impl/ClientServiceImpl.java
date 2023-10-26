package com.arthurgilbert.projectspring.service.impl;

import com.arthurgilbert.projectspring.model.Anddress;
import com.arthurgilbert.projectspring.model.AnddressRepository;
import com.arthurgilbert.projectspring.model.Client;
import com.arthurgilbert.projectspring.model.ClientRepository;
import com.arthurgilbert.projectspring.service.CepService;
import com.arthurgilbert.projectspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AnddressRepository anddressRepository;
    @Autowired
    private CepService cepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public  Client findForId(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert (Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBd = clientRepository.findById(id);
        if (clientBd.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAnddress().getCep();
        Anddress anddress = anddressRepository.findById(cep).orElseGet(() -> {
            Anddress newAnddress = cepService.consultCep(cep);
            anddressRepository.save(newAnddress);
            return newAnddress;
        });
        client.setAnddress(anddress);
        clientRepository.save(client);
    }
}
