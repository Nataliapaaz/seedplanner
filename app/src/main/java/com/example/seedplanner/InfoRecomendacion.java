package com.example.seedplanner;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class InfoRecomendacion extends Fragment {

    private TextView recomendacionesTextView;

    public InfoRecomendacion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_recomendacion, container, false);

        recomendacionesTextView = view.findViewById(R.id.recomendaciones);

        // Obtener selecciones
        Bundle args = getArguments();
        if (args != null) {
            String selectedMes = args.getString("selectedMes");
            String selectedClima = args.getString("selectedClima");

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("recomendaciones")
                    .whereEqualTo("mes", selectedMes)
                    .whereEqualTo("clima", selectedClima)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            if (!queryDocumentSnapshots.isEmpty()) {
                                // Obtener documento
                                DocumentSnapshot documentSnapshot = queryDocumentSnapshots.getDocuments().get(0);
                                String recomendaciones = documentSnapshot.getString("recomendaciones");
                                recomendacionesTextView.setText(recomendaciones);
                            } else {
                                recomendacionesTextView.setText("No se encontraron recomendaciones para esta selección.");
                            }
                        }
                    });
        }

        return view;
    }
}
