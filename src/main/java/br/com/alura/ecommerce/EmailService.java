package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;
public class EmailService {
    public static void main(String[] args) {
        var EmailService = new EmailService();
        var service = new KafkaService(EmailService.class.getSimpleName(),"ECOMMERCE_SEND_EMAIL", EmailService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("------------------------------------------------");
        System.out.println("Enviando e-mail");
        System.out.println("KEY: " + record.key());
        System.out.println("VALUE: " + record.value());
        System.out.println("PARTITIONS: " + record.partition());
        System.out.println("OFFSET: " + record.offset());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
        System.out.println("E-mail enviado");
    }

}

