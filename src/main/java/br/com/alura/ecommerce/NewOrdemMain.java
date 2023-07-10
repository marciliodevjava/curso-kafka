package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class NewOrdemMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        KafkaProducer<String, String> produce = new KafkaProducer<String, String>(properties());
        String value = "123123, 67523 , 789456";
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("ECOMMERCE_NEW_ORDER", value, value);

        produce.send(record, (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("sucesso enviado " + data.topic()
                    + ":::partition " + data.partition()
                    + " / offset " + data.offset()
                    + " / timestamp " + data.timestamp());
        }).get();
    }

    private static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }
}
