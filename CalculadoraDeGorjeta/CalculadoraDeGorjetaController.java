import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class CalculadoraDeGorjetaController {

  @FXML
  private Label gorjetaPorcentagemLabel;

  @FXML
  private TextField contaTextField;
  
  @FXML
  private TextField nPessoasTextField;

  @FXML
  private TextField gorjetaTextField;

  @FXML
  private TextField totalTextField;

  @FXML
  private Slider gorjetaPorcentagemSlider;

  private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
  private static final NumberFormat porcento = NumberFormat.getPercentInstance();

  private BigDecimal porcentagemGorjeta = new BigDecimal(0.15);

  @FXML
  private void calcularBotaoPressionado(ActionEvent evento) {
    try {
      BigDecimal conta = new BigDecimal(contaTextField.getText());
      BigDecimal nPessoas = new BigDecimal(nPessoasTextField.getText());
      BigDecimal gorjeta = conta.multiply(porcentagemGorjeta);
      BigDecimal total = conta.add(gorjeta);

      gorjetaTextField.setText(currency.format(gorjeta));
      totalTextField.setText(currency.format(total));
    } catch (NumberFormatException e) {
      contaTextField.setText("Digite o valor da conta");
      contaTextField.selectAll();
      contaTextField.requestFocus();
      ;
    }
  }

  public void initialize() {
    currency.setRoundingMode(RoundingMode.HALF_UP);

    gorjetaPorcentagemSlider.valueProperty().addListener(new ChangeListener<Number>() {

      @Override
      public void changed(ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo) {
        porcentagemGorjeta = BigDecimal.valueOf(valorNovo.intValue() / 100.0);
        gorjetaPorcentagemLabel.setText(porcento.format(porcentagemGorjeta));
      }
    });
  }

}
