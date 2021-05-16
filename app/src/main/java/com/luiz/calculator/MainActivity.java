package com.luiz.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
            numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
     ponto, soma, subtracao, multiplicaco, divisao, igual,  limpar;


    private TextView txtExpressao, textResultado;
    private ImageView backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicia as váriaveis recebendo seus ID's
         IniciarComponentes();
        getSupportActionBar().hide();

        // recuperando contexto
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicaco.setOnClickListener(this);
        divisao.setOnClickListener(this);

        // usdando methodo separado para limpar minha View
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                textResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pega o que esta na View
               TextView expressao = findViewById(R.id.text_expresao);

               // Converte em strong
               String string =  expressao.getText().toString();

               // se variavel não estiver vazia
               if (!string.isEmpty()){

                   byte varZero = 0;
                   int varUm = string.length()-1;
                   String txtExpressao = string.substring(varZero, varUm);
                   expressao.setText(txtExpressao);
               }

                textResultado.setText("");



            }
        });


        // função calculo depois de igualdade ser pressionada
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // foi add uma biblioteca para facilitar
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult){
                        textResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        textResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }



            }
        });






    }


    // methodo para receber ID's
    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.bt_zero);
        numeroUm = findViewById(R.id.bt_um);
        numeroDois = findViewById(R.id.bt_dois);
        numeroTres = findViewById(R.id.bt_tres);
        numeroQuatro = findViewById(R.id.bt_quatro);
        numeroCinco = findViewById(R.id.bt_cinco);
        numeroSeis = findViewById(R.id.bt_seis);
        numeroSete = findViewById(R.id.bt_sete);
        numeroOito = findViewById(R.id.bt_oito);
        numeroNove = findViewById(R.id.bt_nove);
        ponto = findViewById(R.id.bt_ponto);
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        multiplicaco = findViewById(R.id.bt_multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        igual = findViewById(R.id.bt_igualdade);
        limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.text_expresao);
        textResultado = findViewById(R.id.text_resultado);
        backspace = findViewById(R.id.backspace);
    }


     // methodo para acrescentar uma caractere
    public void acrescentarUmaExpressao(String string, boolean limpar_dados){

        // verifica se resultado tem algum valor
        // se não ele seta pra vazio
       if(textResultado.getText().equals("")){
           txtExpressao.setText("");
       }
       // limpar os dados
       if(limpar_dados){
           textResultado.setText(" ");
           txtExpressao.append(string);
       }else{
           txtExpressao.append(textResultado.getText());
           txtExpressao.append(string);
           textResultado.setText(" ");
       }

    }

    // recuperando valores atraves click

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_zero:
                acrescentarUmaExpressao("0", true);
                break;

            case R.id.bt_um:
                acrescentarUmaExpressao("1", true);
                break;
            case R.id.bt_dois:
                acrescentarUmaExpressao("2", true);
                break;

            case R.id.bt_tres:
                acrescentarUmaExpressao("3", true);
                break;

            case R.id.bt_quatro:
                acrescentarUmaExpressao("4", true);
                break;

            case R.id.bt_cinco:
                acrescentarUmaExpressao("5", true);
                break;

            case R.id.bt_seis:
                acrescentarUmaExpressao("6", true);
                break;

            case R.id.bt_sete:
                acrescentarUmaExpressao("7", true);
                break;

            case R.id.bt_oito:
               acrescentarUmaExpressao("8", true);
                break;

            case R.id.bt_nove:
                acrescentarUmaExpressao("9", true);
                break;

            case R.id.bt_ponto:
                acrescentarUmaExpressao(".", true);
                break;

            case R.id.bt_soma:
                acrescentarUmaExpressao("+", false);
                break;

            case R.id.bt_subtracao:
                acrescentarUmaExpressao("-", false);
                break;

            case R.id.bt_multiplicacao:
                acrescentarUmaExpressao("*", false);
                break;

            case R.id.bt_divisao:
                acrescentarUmaExpressao("/", false);
                break;


        }

    }
}