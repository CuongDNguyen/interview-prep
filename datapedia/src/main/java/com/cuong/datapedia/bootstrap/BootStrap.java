package com.cuong.datapedia.bootstrap;

import com.cuong.datapedia.domain.Category;
import com.cuong.datapedia.domain.DataStructure;
import com.cuong.datapedia.repositories.CategoryRepository;
import com.cuong.datapedia.repositories.DataStructureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {


    private final CategoryRepository categoryRepository;
    private final DataStructureRepository dataStructureRepository;

    public BootStrap(CategoryRepository categoryRepository, DataStructureRepository dataStructureRepository) {
        this.categoryRepository = categoryRepository;
        this.dataStructureRepository = dataStructureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {

            System.out.println("Loading data...###");

            categoryRepository.save(Category.builder().description("Data Structures").build()).block();
            categoryRepository.save(Category.builder().description("Algorithms").build()).block();
            categoryRepository.save(Category.builder().description("Time and Space Complexity").build()).block();

            dataStructureRepository.save(DataStructure.builder().dataName("LinkedList").build()).block();
            dataStructureRepository.save(DataStructure.builder().dataName("Trees").build()).block();
            dataStructureRepository.save(DataStructure.builder().dataName("Graphs").build()).block();

            System.out.println("Loaded categories: " + categoryRepository.count().block());
            System.out.println("Loaded data structures: " + dataStructureRepository.count().block());
        }
    }
}
