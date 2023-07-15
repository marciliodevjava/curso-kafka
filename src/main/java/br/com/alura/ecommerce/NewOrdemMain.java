package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrdemMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        KafkaProducer<String, String> produce = new KafkaProducer<String, String>(properties());

        int mensagem1 = new Random().nextInt(1001) + 1000;
        int mensagem2 = new Random().nextInt(4001) + 1000;
        int mensagem3 = new Random().nextInt(6001) + 1000;

        String key = UUID.randomUUID().toString();

        String value = mensagem1 + ", " + mensagem2 + ", " + mensagem3;
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("ECOMMERCE_NEW_ORDER", key, value);

        Callback callback = (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("sucesso enviado " + data.topic()
                    + ":::partition " + data.partition()
                    + " / offset " + data.offset()
                    + " / timestamp " + data.timestamp());
        };
        String email = "Bem-vindo, seu pedido será processado.";
        ProducerRecord<String, String> emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL", key, email);

        produce.send(record, callback).get();
        produce.send(emailRecord, callback).get();
    }

    private static Properties properties() {

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }
}
