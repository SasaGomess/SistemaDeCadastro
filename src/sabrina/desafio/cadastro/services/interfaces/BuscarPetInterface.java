package sabrina.desafio.cadastro.services.interfaces;

import sabrina.desafio.cadastro.entities.Pet;

import java.util.List;

public interface BuscarPetInterface {
    List<Pet> buscandoPet(List<Pet>list, Pet pet);
}
