package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText numberInput;
	private int number_random = 0;
	private Random rand;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numberInput = findViewById(R.id.number_input);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		rand = new Random();
		if(number_random == 0){
			number_random = rand.nextInt(100);
		}
		else{
			number_random = number_random;
		}
	}

	public void handleGuess(View view) {
		initRandomNumber();
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		if(numberInput.getText().toString().trim().equals("")){
			Toast.makeText(this,"Data Tidak Boleh Kosong !!",Toast.LENGTH_LONG).show();
		}
		else{
			int number_check = Integer.parseInt(numberInput.getText().toString().trim());
			if(number_check > number_random){
				Toast.makeText(this,"Tebakan anda terlalu besar !",Toast.LENGTH_LONG).show();
				numberInput.setText("");
			}
			else if(number_check < number_random){
				numberInput.setText("");
				Toast.makeText(this,"Tebakan anda terlalu kecil !",Toast.LENGTH_LONG).show();
			}
			else{
				Toast.makeText(this,"Tebakan anda benar !",Toast.LENGTH_LONG).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		numberInput.setText("");
		Toast.makeText(this,"Reset Berhasil !",Toast.LENGTH_LONG).show();
	}
}