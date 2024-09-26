package sti.globals;

import org.junit.jupiter.api.Test;
import org.openl.rules.runtime.RulesEngineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTest.class);

    @Test
    void hourTest() {
        double start = System.currentTimeMillis();

        //define the interface
        RulesEngineFactory<Simple > rulesFactory =
                new RulesEngineFactory<Simple>("src/main/resources/TemplateRules.xlsx",
                        Simple.class);

        Simple rules = (Simple) rulesFactory.newInstance();
        rules.hello1(13);

        LOGGER.info("Time taken: {} ms", System.currentTimeMillis() - start);
    }

    @Test
    void discountTest() {
        double start = System.currentTimeMillis();

        //define the interface
        RulesEngineFactory<Simple > rulesFactory =
                new RulesEngineFactory<Simple>("src/main/resources/TemplateRules.xlsx",
                        Simple.class);

        Simple rules = (Simple) rulesFactory.newInstance();
        rules.applyDiscount("Premium", 200);
        rules.applyDiscount("Standard", 200);
        rules.applyDiscount("Normal", 200);
        LOGGER.info("Time taken: {} ms", System.currentTimeMillis() - start);
    }
}
