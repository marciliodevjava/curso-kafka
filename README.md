# kafka

- Kafka: Produtores, Consulmidores e streams.


- Configurações no windows
-

Para executar o Kafka localmente em seu computador com Windows, siga estas etapas:

Baixe o Kafka: Acesse o site oficial do Apache Kafka (https://kafka.apache.org/downloads) e baixe a versão mais recente
do Kafka. Escolha a versão binária apropriada para o Windows.

Extraia o arquivo: Após o download, extraia o arquivo compactado para um diretório de sua escolha. Por exemplo, você
pode extrair para a pasta C:\kafka.

- Configuração do ZooKeeper

Antes de iniciar o servidor Kafka, é necessário configurar o ZooKeeper. Navegue até o diretório do Kafka e abra o
arquivo config/zookeeper.properties em um editor de texto.

Encontre a linha dataDir=/tmp/zookeeper e altere o caminho para um diretório válido no Windows. Por exemplo, você pode
alterar para dataDir=C:/kafka/data/zookeeper.

- Inicie o servidor ZooKeeper

Abra o prompt de comando (CMD) como administrador. Navegue até o diretório do Kafka e execute o seguinte comando para
iniciar o servidor ZooKeeper:
Encontre o arquivo server.properties e altere "#listeners=PLAINTEXT://:9092" para "listeners=PLAINTEXT://127.0.0.1:9092"

- Configuraçoes no Linux

- Baixe o Kafka:

Acesse o site oficial do Apache Kafka (https://kafka.apache.org/downloads) e baixe a versão mais recente do Kafka.
Escolha a versão binária adequada para o Linux.

- Extraia o arquivo

Após o download, extraia o arquivo compactado para um diretório de sua escolha. Por exemplo, você pode extrair para a
pasta /opt/kafka.

- Configuração do ZooKeeper

O ZooKeeper é necessário para o Kafka. Navegue até o diretório do Kafka e abra o arquivo config/zookeeper.properties em
um editor de texto.

- Verifique e configure o caminho do dataDir

Certifique-se de que o caminho dataDir esteja configurado corretamente. Por exemplo, você pode definir
dataDir=/opt/kafka/data/zookeeper.

- Inicie o servidor ZooKeeper

Abra um terminal e navegue até o diretório do Kafka. Execute o seguinte comando para iniciar o servidor ZooKeeper:

- Configure o servidor Kafka

Abra o arquivo config/server.properties em um editor de texto.

- Verifique e configure a configuração listeners

Certifique-se de que a configuração listeners esteja correta. Por exemplo, você pode definir listeners=PLAINTEXT:
//localhost:9092.

- Copy code

> WINDOWS: bin\windows\zookeeper-server-start.bat config\zookeeper.properties

> LINUX: bin/zookeeper-server-start.sh config/zookeeper.properties

- Inicie o servidor Kafka: Em uma nova janela do prompt de comando (CMD), navegue até o diretório do Kafka e execute o
  seguinte comando para iniciar o servidor Kafka:

- Copy code

> WINDOWS: bin\windows\kafka-server-start.bat config\server.properties

> LINUX: bin/kafka-server-start.sh config/server.properties

O Kafka agora está sendo executado localmente em sua máquina.

- Crie um tópico: Para testar a funcionalidade do Kafka, você pode criar um tópico. Abra uma nova janela do prompt de
  comando (CMD) e navegue até o diretório do Kafka. Execute o seguinte comando para criar um tópico chamado "
  meu-topico":

- Copy code

> WINDOWS: bin\windows\kafka-topics.bat --create --topic meu-topico --bootstrap-server localhost:9092 --partitions 1
> --replication-factor 1

> LINUX: bin/kafka-topics.sh --create --topic meu-topico --bootstrap-server localhost:9092 --partitions 1
> --replication-factor 1

Agora você tem o Kafka em execução no seu computador com Windows. Você pode explorar outras funcionalidades, como
produção e consumo de mensagens, usando as ferramentas fornecidas pelo Kafka, como kafka-console-producer e
kafka-console-consumer. Certifique-se de consultar a documentação oficial do Kafka para obter mais informações sobre
como utilizar essas ferramentas e desenvolver aplicativos Kafka.

- Criando um tropic no Kafka:

> WINDOWS: bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
> --topic LOJA_NOVO_PEDIDO

> LINUX: bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic
> LOJA_NOVO_PEDIDO

- Lista os tropic no kafka:

> WINDOWS: bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

> LINUX: bin/kafka-topics.sh --list --bootstrap-server localhost:9092

- Rodar o produtor

> WINDOWS: bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic LOJA_NOVO_PEDIDO

> LINUX: bin/kafka-console-producer.sh --broker-list localhost:9092 --topic LOJA_NOVO_PEDIDO

> pedido1,500.00

> pedido2,780.98

> pedido3,150.15

> pedido4,1280.80

- List as mensagem desdo primiro pedido

> WINDOWS: bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO
> --from-beginning

> LINUX: bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO --from-beginning

- Aumentar o número de partições de um topic

> WINDOWS: bin\windows\kafka-topics.bat --alter --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER
> --partitions 3

> LINUX: bin/kafka-topics.sh --alter --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --partitions 3

