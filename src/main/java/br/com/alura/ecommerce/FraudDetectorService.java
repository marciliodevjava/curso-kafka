package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

    public static void main(String[] args) {
        var fraudService = new FraudDetectorService();
        var service = new KafkaService(FraudDetectorService.class.getSimpleName(),"ECOMMERCE_NEW_ORDER", fraudService::parce);

        service.run();
    }

    private void parce(ConsumerRecord<String, String> record) {
        System.out.println("------------------------------------------------");
        System.out.println("Prcessando novo pedido, checando se é uma fraude");
        System.out.println("KEY: " + record.key());
        System.out.println("VALUE: " + record.value());
        System.out.println("PARTITIONS: " + record.partition());
        System.out.println("OFFSET: " + record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
        System.out.println("Ordem processada");
    }
}
