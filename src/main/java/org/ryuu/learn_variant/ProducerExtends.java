package org.ryuu.learn_variant;

import java.util.ArrayList;
import java.util.List;

/**
 * Pulling items out, it‘s a producer, use extends
 */
public class ProducerExtends {
    private static class EnergySourceProducer {
        public void beConsume() {
            System.out.println("energy source consumed");
        }
    }

    private static class VegetableProducer extends EnergySourceProducer {
        @Override
        public void beConsume() {
            System.out.println("vegetable consumed");
        }
    }

    private static class BambooProducer extends VegetableProducer {
        @Override
        public void beConsume() {
            System.out.println("bamboo consumed");
        }
    }

    private static class EnergySourceConsumer {
        public void consume(List<? extends EnergySourceProducer> producers) {
            for (EnergySourceProducer producer : producers) {
                producer.beConsume();
            }
        }
    }

    private static class VegetableConsumer {
        public void consume(List<? extends VegetableProducer> producers) {
            for (EnergySourceProducer producer : producers) {
                producer.beConsume();
            }
        }
    }

    private static class BambooConsumer {
        public void consume(List<? extends BambooProducer> producers) {
            for (EnergySourceProducer producer : producers) {
                producer.beConsume();
            }
        }
    }

    public static void main(String[] args) {
        EnergySourceProducer energySourceProducer = new EnergySourceProducer();
        ArrayList<EnergySourceProducer> energySourceProducers = new ArrayList<>() {{
            add(energySourceProducer);
        }};
        VegetableProducer vegetableProducer = new VegetableProducer();
        ArrayList<VegetableProducer> vegetableProducers = new ArrayList<>() {{
            add(vegetableProducer);
        }};
        BambooProducer bambooProducer = new BambooProducer();
        ArrayList<BambooProducer> bambooProducers = new ArrayList<>() {{
            add(bambooProducer);
        }};
        EnergySourceConsumer energySourceConsumer = new EnergySourceConsumer();
        energySourceConsumer.consume(energySourceProducers);
        energySourceConsumer.consume(vegetableProducers);
        energySourceConsumer.consume(bambooProducers);

        VegetableConsumer vegetableConsumer = new VegetableConsumer();
        vegetableConsumer.consume(vegetableProducers);
        vegetableConsumer.consume(bambooProducers);

        BambooConsumer bambooConsumer = new BambooConsumer();
        bambooConsumer.consume(bambooProducers);
    }
}