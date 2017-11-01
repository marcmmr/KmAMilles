package edu.upc.eseiaat.pma.kmamilles;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.FloatProperty;
        import android.widget.Button;
        import android.widget.EditText;
        import android.util.Log;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_a_milles = (Button) findViewById(R.id.btn_a_milles); //es retorna un objecte tipus view però es passa a tipus botó amb (Button)
        Button btn_a_km = (Button) findViewById(R.id.btn_a_km);

        final EditText num_milles = (EditText) findViewById(R.id.num_milles);//obtenim una ref de l'objecte de la pantalla
        final EditText num_km = (EditText) findViewById(R.id.num_km); // es posa sempre final... i referenciem per poder manipularlo

        btn_a_milles.setOnClickListener(new View.OnClickListener(){ //mètode per detectar si el btn está clicat o no, CTRL + SPACE
            @Override
            public void onClick (View v) {
                String skm = num_km.getText().toString(); //ho passem a string perquè no sigui un editable que era el que ens donava
                float km = Float.parseFloat(skm); //convertim un string en float
                float milles = km/1.609f;// f per poder dividir entre 2 floats
                String smilles= String.format("%f",milles); //de tipus float a string
                num_milles.setText(smilles); //actualitzar de milles que està en string a text
            }
        });

        btn_a_km.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                String smilles = num_milles.getText().toString(); //passema milles el smilles
                float milles = Float.parseFloat(smilles);
                float km = milles * 1.609f;
                String skm = String.format("%f", km);// formategem els km
                num_km.setText(skm);
            }
        });
    }
}