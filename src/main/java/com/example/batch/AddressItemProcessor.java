package com.example.batch;

import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressItemProcessor implements ItemProcessor<Address, Address> {

    private static final Logger logger = LoggerFactory.getLogger(AddressItemProcessor.class);

    @Override
    public Address process(Address address) {
        // Skip if essential data is missing
        if (address.getStreet() == null || address.getCity() == null || address.getState() == null) {
            logger.warn("Skipping record due to missing address fields: {}", address);
            return null;
        }

        // Logging original data
        logger.info("Processing address: {}", address);

        // Normalize: Trim & convert to uppercase
        address.setStreet(address.getStreet().trim());
        address.setCity(address.getCity().trim().toUpperCase());
        address.setState(address.getState().trim().toUpperCase());

        // Format zip code (e.g., remove spaces)
        if (address.getZipCode() != null) {
            address.setZipCode(address.getZipCode().trim().replaceAll("\\s+", ""));
        }

        // Log after processing
        logger.info("Processed address: {}", address);

        // Return processed record
        return address;
    }
}