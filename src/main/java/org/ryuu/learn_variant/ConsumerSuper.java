package org.ryuu.learn_variant;

import java.util.ArrayList;
import java.util.List;

/**
 * Stuffing items in, it's a consumer, use super
 */
public class ConsumerSuper {
    private static class Entertainment {
        public void play() {
            System.out.println("entertainment play");
        }
    }

    private static class Music extends Entertainment {
        @Override
        public void play() {
            System.out.println("music play");
        }
    }

    private static class Metal extends Music {
        @Override
        public void play() {
            System.out.println("metal play");
        }
    }

    private static class EntertainmentProducer {
        public void produce(List<? super Entertainment> consumer) {
            consumer.add(new Entertainment());
        }
    }

    private static class MusicProducer extends EntertainmentProducer {
        @Override
        public void produce(List<? super Entertainment> consumer) {
            consumer.add(new Music());
        }
    }

    private static class MetalProducer extends MusicProducer {
        @Override
        public void produce(List<? super Entertainment> consumer) {
            consumer.add(new Metal());
        }
    }

    public static void main(String[] args) {
        ArrayList<Entertainment> consumeGoods = new ArrayList<>();
        new EntertainmentProducer().produce(consumeGoods);
        new MusicProducer().produce(consumeGoods);
        new MetalProducer().produce(consumeGoods);

        for (Entertainment product : consumeGoods) {
            product.play();
        }
    }
}