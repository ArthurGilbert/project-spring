package com.arthurgilbert.projectspring.service;

import com.arthurgilbert.projectspring.model.Client;

public interface ClientService {

        Iterable<Client> findAll();

        Client findForId(Long id);

        void insert(Client client);

        void update(Long id, Client client);

        void delete(Long id);

}
