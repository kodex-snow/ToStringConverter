package kot.kotsnow;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Controller implements Initializable {

	@FXML
	TextArea beforeConvertArea;

	@FXML
	TextArea afterConvertArea;

	@FXML
	Button btn_convert;

	@FXML
	Button btn_clipboard;

	String text;
	final Clipboard clipboard;
	final ClipboardContent clipboardContent;

	public Controller (){
		text = " ";
		clipboard = Clipboard.getSystemClipboard();
		clipboardContent = new ClipboardContent();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		afterConvertArea.setEditable(false);

	}

	public void convert(){
		text = beforeConvertArea.getText();
		replaceSpecialChars();
		afterConvertArea.setText(text);
	}

	public void copyToClipboard(){

		clipboardContent.putString(afterConvertArea.getText());
		clipboard.setContent(clipboardContent);

	}

	public void replaceSpecialChars(){
		text = text.replace("\\","\\\\");
		text = text.replace("\"", "\\\"");

	}

}
