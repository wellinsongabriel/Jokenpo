package br.com.wellinsongabriel.jokenpo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgEscolhaSmartphone, imgPedra, imgPapel, imgTesoura, imgEscolhaUsuario;
    String jogadaSmartphone, jogadaUsuario;
    TextView txtPontuacaoSmartphone, txtPontuacaoUsuario, txtInformacao;
    int pontuacaoMaquina=0;
    int pontuacaoUsuario=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgEscolhaSmartphone = findViewById(R.id.imgEscolhaSmartphone);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);
        imgEscolhaUsuario = findViewById(R.id.imgEscolhaUsuario);
        txtPontuacaoSmartphone = findViewById(R.id.txtPontuacaoSmartphone);
        txtPontuacaoUsuario = findViewById(R.id.txtPontuacaoUsuario);
        txtInformacao = findViewById(R.id.txtInformacao);
    }

    public void pedra(View view){
        imgEscolhaUsuario.setImageResource(R.drawable.pedra);
        jogadaUsuario = "pedra";
        jogadaMaquina();
        pontuar();
    }

    public void papel(View view){
        imgEscolhaUsuario.setImageResource(R.drawable.papel);
        jogadaUsuario = "papel";
        jogadaMaquina();
        pontuar();
    }

    public void tesoura(View view){
        imgEscolhaUsuario.setImageResource(R.drawable.tesoura);
        jogadaUsuario = "tesoura";
        jogadaMaquina();
        pontuar();
    }

    private String jogadaMaquina(){
        String[] jogada = {"pedra", "papel", "tesoura"};
        int i = new Random().nextInt(3);
        jogadaSmartphone = jogada[i];
        setarImagemMaquina(jogada[i]);
        return jogada[i];
    }
    private void setarImagemMaquina(String jogadda){
        if(jogadda.equals("pedra")){
            imgEscolhaSmartphone.setImageResource(R.drawable.pedra);
        }else
        if(jogadda.equals("papel")){
            imgEscolhaSmartphone.setImageResource(R.drawable.papel);
        }else{
            imgEscolhaSmartphone.setImageResource(R.drawable.tesoura);
        }
    }

    private void pontuar(){

        if(jogadaUsuario.equalsIgnoreCase(jogadaSmartphone)) {
            txtInformacao.setText("Oh, não! Empatamos");
        }
        else{
            if (jogadaUsuario.equalsIgnoreCase("papel")) {
                if (jogadaSmartphone.equalsIgnoreCase("pedra")) {
                    pontuacaoUsuario++;
                    verificar();
                } else {
                    pontuacaoMaquina++;
                    verificar();
                }
            } else if (jogadaUsuario.equalsIgnoreCase("tesoura")) {
                if (jogadaSmartphone.equalsIgnoreCase("papel")) {
                    pontuacaoUsuario++;
                    verificar();
                } else {
                    pontuacaoMaquina++;
                    verificar();
                }
            } else {
                if (jogadaSmartphone.equalsIgnoreCase("tesoura")) {
                    pontuacaoUsuario++;
                    verificar();
                } else {
                    pontuacaoMaquina++;
                    verificar();
                }
            }
            txtPontuacaoSmartphone.setText("" + pontuacaoMaquina);
            txtPontuacaoUsuario.setText("" + pontuacaoUsuario);
        }


    }
    private void verificar(){
        if(pontuacaoMaquina<5&&pontuacaoUsuario<5) {
            if(pontuacaoUsuario>pontuacaoMaquina){
                txtInformacao.setText("Você, humano ganhou");
            }else{
                txtInformacao.setText("Eu smartphone ganhei!");

            }
        }else{
            if(pontuacaoUsuario>pontuacaoMaquina){;
                txtInformacao.setText("Parabéns humano");
            }else{
                txtInformacao.setText("Bip bip! Eu sou o melhor");

            }
            txtPontuacaoSmartphone.setText("" + pontuacaoMaquina);
            txtPontuacaoUsuario.setText("" + pontuacaoUsuario);
            imgEscolhaUsuario.setImageResource(R.drawable.padrao);
            imgEscolhaSmartphone.setImageResource(R.drawable.padrao);
            imgPedra.setImageResource(R.drawable.padrao);
            imgPedra.setClickable(false);
            imgPapel.setImageResource(R.drawable.padrao);
            imgPapel.setClickable(false);
            imgTesoura.setImageResource(R.drawable.padrao);
            imgTesoura.setClickable(false);
        }
    }
}