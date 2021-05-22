package com.example.tp1arrayadapater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListeNoms extends AppCompatActivity {
    ListView vListeNoms;
    String[] TNomPrenom = {"Mouline Ahmed", "Benali Yasser", "Mouradi Ayman", "Boudine Ali"};
    Contact contactCourant;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtNom = (EditText) findViewById(R.id.edtNom);
        EditText edtPrenom = (EditText) findViewById(R.id.edtPrenom);
        Button btAjouter = (Button) findViewById(R.id.btAdd);
        Button btSuppriemr = (Button) findViewById(R.id.btDel);
        Button btModifier = (Button) findViewById(R.id.btUpd);
        vListeNoms = (ListView) findViewById(R.id.maListe);
        DataSource dataSrc = new DataSource(this);
        try {
            dataSrc.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Contact> lst = dataSrc.getContacts();
        ArrayAdapter<Contact> monAdaptateur = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_2,
                android.R.id.text1, lst) {
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
                    parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText(lst.get(position).getNom());
                text2.setText(lst.get(position).getPrenom());
                return view;
            }
        };
        vListeNoms.setAdapter(monAdaptateur);
        vListeNoms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long
                    id) {
                TextView tvNom = (TextView) view.findViewById(android.R.id.text1);
                TextView tvPrenom = (TextView) view.findViewById(android.R.id.text2);
                contactCourant = (Contact) adapterView.getAdapter().getItem(position);
                //int positionSelectionnee=position;
                edtNom.setText(contactCourant.getNom());
                edtPrenom.setText(contactCourant.getPrenom());

            }
        });
        btAjouter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Contact c = new Contact(1, edtNom.getText().toString(), edtPrenom.getText().toString());
                lst.add(c);
                dataSrc.creerContact(c.getNom(), c.getPrenom());
                monAdaptateur.notifyDataSetChanged();
                //monAdaptateur.add(c);
                edtNom.setText("");
                edtPrenom.setText("");
            }
        });
        btSuppriemr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //monAdaptateur.remove(monAdaptateur.getItem(positionSelectionnee));
                dataSrc.deleteContact(contactCourant);
                monAdaptateur.remove(contactCourant);
                monAdaptateur.notifyDataSetChanged();
            }
        });
        btModifier.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                contactCourant.setNom(edtNom.getText().toString());
                contactCourant.setPrenom(edtPrenom.getText().toString());
                dataSrc.updateContact(contactCourant);
                monAdaptateur.notifyDataSetChanged();
            }
        });
    }
}