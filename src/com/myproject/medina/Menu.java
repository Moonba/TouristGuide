package com.myproject.medina;
 
import java.util.ArrayList;
import java.util.HashMap;
 
import com.myproject.medina.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
 
public class Menu extends Activity {
 
	private ListView maListViewPerso;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        //Récupération de la listview créée dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
 
        //Création de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
 
        //Création d'une HashMap pour insérer les informations du premier item de notre listView
        map = new HashMap<String, String>();
        //on insère un élément titre que l'on récupérera dans le textView titre créé dans le fichier affichageitem.xml
        map.put("titre", "Take A Walk !");
        //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier affichageitem.xml
        map.put("description", "Discover the Medina of Tunis ");
        //on insère la référence à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier affichageitem.xml
        map.put("img", String.valueOf(R.drawable.maps));
        //enfin on ajoute cette hashMap dans la arrayList
        listItem.add(map);
 
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
 
        map = new HashMap<String, String>();
        map.put("titre", "Talk Tunisian");
        map.put("description", "Learn the tunisian arabic dialect and communicate with the friendly locals ");
        map.put("img", String.valueOf(R.drawable.googletalk));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Tunisian Food");
        map.put("description", "Taste the delicious food <3 and get ready for spiciness");
        map.put("img", String.valueOf(R.drawable.food));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Tunisian Songs ");
        map.put("description", "Enjoy different types of music");
        map.put("img", String.valueOf(R.drawable.music));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Traditional Clothes ");
        map.put("description", "Each region has her different clothing style from the north to the south . Wedding is the best occasion to see traditionnal fashion show !");
        map.put("img", String.valueOf(R.drawable.clothes));
        listItem.add(map);
     
        map = new HashMap<String, String>();
        map.put("titre", "Contact us");
        map.put("description", "Something went wrong ?Something you liked ?Let us know !");
        map.put("img", String.valueOf(R.drawable.email));
        listItem.add(map);
        
        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"img", "titre", "description"}, new int[]  {R.id.img, R.id.titre, R.id.description});
 
        //On attribut à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mSchedule);
 
        //Enfin on met un écouteur d'évènement sur notre listView
        maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
			
        	 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		    CallFunc(position);
        		}
    
       
        		private void CallFunc(int position) {
        		Intent intent = null ;
        		switch (position) {
        		  case 0:
        		    intent = new Intent(getBaseContext() , Takeawalk.class);
        		  break;
        		  case 1 :
        		   intent = new Intent(getBaseContext() , TalkTunisian.class);
        		  break;
        		  case 2 :
           		   intent = new Intent(getBaseContext() , TasteTunisianFood.class);
           		  break; 
        		  case 3 :
           		   intent = new Intent(getBaseContext() , TunisianSong.class);
           		  break; 
        		  case 4 :
              	   intent = new Intent(getBaseContext() , TraditionalClothes.class);
              	  break; 
        		  case 5 :
                 	   intent = new Intent(getBaseContext() , Contact.class);
                 	  break; 
        		}
        		// pour éviter le if tu peux faire un return sur default du switch
        		if(intent != null)
        		    startActivity(intent); 
        		}
        	
         } ) ;
 
    }

	@Override
	protected void onResume() {
		super.onResume();
	} 
}
