package sabrina.desafio.cadastro.services.interfaces;

import sabrina.desafio.cadastro.entities.Pet;

import java.util.List;
import java.util.Scanner;

public interface BuscarPetInterface {
    List<Pet> buscandoPet( Scanner scanner);
}
