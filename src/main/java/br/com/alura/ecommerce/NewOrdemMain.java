package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

class NewOrdemMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (var dispatcher = new KafkaDispatcher()) {

            int mensagem1 = new Random().nextInt(1001) + 1000;
            int mensagem2 = new Random().nextInt(4001) + 1000;
            int mensagem3 = new Random().nextInt(6001) + 1000;

            String key = UUID.randomUUID().toString();
            String value = mensagem1 + ", " + mensagem2 + ", " + mensagem3;
            dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

            String email = "Bem-vindo, seu pedido será processado.";
            ProducerRecord<String, String> emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL", key, email);
            dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
        }
    }
}
