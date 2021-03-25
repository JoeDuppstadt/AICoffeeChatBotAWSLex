package sample;

import java.net.URISyntaxException;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextRequest;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextResponse;

import java.net.URISyntaxException;
import java.util.UUID;
public class Testing {



    /**
     * This is a sample application to interact with a bot using RecognizeText API.
     */

        public static void main(String[] args) throws URISyntaxException, InterruptedException {
            String botId = "9DFRNPZAV1";
            String botAliasId = "TSTALIASID";
            String localeId = "en_US";
            String accessKey = "AKIAT6GUK3MJLNYJU5EF";
            String secretKey = "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";
            String sessionId = UUID.randomUUID().toString();
            Region region = Region.US_EAST_1; // pick an appropriate region

            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
            AwsCredentialsProvider awsCredentialsProvider = StaticCredentialsProvider.create(awsCreds);

            LexRuntimeV2Client lexV2Client = LexRuntimeV2Client
                    .builder()
                    .credentialsProvider(awsCredentialsProvider)
                    .region(region)
                    .build();

            // utterance 1
            String userInput = "What is your name";
            RecognizeTextRequest recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            RecognizeTextResponse recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 2
            userInput = "When are you open";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 3
            userInput = "When do you close";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 4
            userInput = "When are the busy hours";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 5
            userInput = "What kind of coffee do you have";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 6
            userInput = "What is your favorite drink";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });
            // utterance 7
            userInput = "How do i cancel my order";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 8
            userInput = "What kind of drinks do you have";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 9
            userInput = "What is the price of a small coffee";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 10
            userInput = "What is the price of a medium coffee";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 11
            userInput = "what is the price of a large coffee";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 12
            userInput = "What payment methods do you accept";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 13
            userInput = "What is your phone number";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });

            // utterance 14
            userInput = "How do i place an order";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });
            // utterance 15
            userInput = "Can i see your menu";
            recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

            System.out.println("User : " + userInput);
            recognizeTextResponse.messages().forEach(message -> {
                System.out.println("Bot : " + message.content());
            });
        }

        private static RecognizeTextRequest getRecognizeTextRequest(String botId, String botAliasId, String localeId, String sessionId, String userInput) {
            RecognizeTextRequest recognizeTextRequest = RecognizeTextRequest.builder()
                    .botAliasId(botAliasId)
                    .botId(botId)
                    .localeId(localeId)
                    .sessionId(sessionId)
                    .text(userInput)
                    .build();
            return recognizeTextRequest;
        }
    }


