package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client;
import software.amazon.awssdk.services.lexruntimev2.model.Message;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextRequest;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextResponse;
import java.util.UUID;

public class Controller {

    @FXML
    private ImageView sendButton;

    @FXML private TextArea chatBoxTextField;

    @FXML private TextArea chatBoxTextBox;

    private String botId = "9DFRNPZAV1";
    private String botAliasId = "TSTALIASID";
    private String localeId = "en_US";
    private String accessKey = "AKIAT6GUK3MJLNYJU5EF"; // needs changed for each user
    private String secretKey = "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"; // needs changed
    private String sessionId = UUID.randomUUID().toString();
    private Region region = Region.US_EAST_1;
    private String messageHistory = "";
    private int count = 0;



    @FXML void sendButtonClicked(MouseEvent event) {
        Runnable letsTalk = new Runnable() {
            @Override
            public void run() {
                AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
                AwsCredentialsProvider awsCredentialsProvider = StaticCredentialsProvider.create(awsCreds);

                LexRuntimeV2Client lexV2Client = LexRuntimeV2Client
                        .builder()
                        .credentialsProvider(awsCredentialsProvider)
                        .region(region)
                        .build();

                // conversation stuff
                String userInput = chatBoxTextBox.getText();
                RecognizeTextRequest recognizeTextRequest = getRecognizeTextRequest(botId, botAliasId, localeId, sessionId, userInput);
                RecognizeTextResponse recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

                if (count > 0) {
                    messageHistory += "\n" + "User: " + userInput + "\n";
                } else { // we dont have to have a line space the first time a user asks a question
                    messageHistory += "User: " + userInput + "\n";
                }
                // get bot responses and writes them to the string builder and displays the messages
                for (Message x : recognizeTextResponse.messages()) {
                    messageHistory += "Bot: " + x.content();
                    chatBoxTextField.setText(messageHistory + "\n");
                }
                count++; // increment the count
                chatBoxTextBox.clear();
            }
        };
        letsTalk.run();
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

    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatBoxTextBox.requestFocus();
            }
        });
    }
}
