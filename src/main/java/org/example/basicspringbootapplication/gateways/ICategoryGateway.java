package org.example.basicspringbootapplication.gateways;

import org.example.basicspringbootapplication.DTO.CategoryDTO;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;

}
