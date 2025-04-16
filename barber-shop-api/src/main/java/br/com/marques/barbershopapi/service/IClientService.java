package br.com.marques.barbershopapi.service;

import br.com.marques.barbershopapi.entity.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);
}
