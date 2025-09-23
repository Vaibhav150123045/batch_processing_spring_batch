package com.example.batch;

import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) {
        // Skip if firstName or lastName is missing
        if (person.getFirstName() == null || person.getLastName() == null) {
            logger.warn("Skipping record due to missing data: {}", person);
            return null; // Returning null tells Spring Batch to skip this record
        }

        // Logging original data
        logger.info("Processing record: {}", person);

        // Transform: convert names to uppercase
        String firstName = person.getFirstName().trim().toUpperCase();
        String lastName = person.getLastName().trim().toUpperCase();

        person.setFirstName(firstName);
        person.setLastName(lastName);

        // Enrich data: Add derived fullName field (if needed in future)
        logger.info("Processed record full name: {}", person.getFullName());

        // Return processed record
        return person;
    }
}