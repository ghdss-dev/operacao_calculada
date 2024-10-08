package dev.gustavo.operacao_calculada.view.quimica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import dev.gustavo.operacao_calculada.apoio.quimica_apoio.Util_Escalar_Ph;
import dev.gustavo.operacao_calculada.databinding.FragmentEscalarPhBinding;
import dev.gustavo.operacao_calculada.model.quimica_model.Escalar_Ph_model;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Escalar_Ph_Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Escalar_Ph_Fragmento extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentEscalarPhBinding binding;

    public Escalar_Ph_Fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Escalar_Ph_Fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static Escalar_Ph_Fragmento newInstance(String param1, String param2) {
        Escalar_Ph_Fragmento fragment = new Escalar_Ph_Fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEscalarPhBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = binding.editNumero.getText().toString();

                if (numero.isEmpty()) {

                    Toast.makeText(getActivity(), "Digite um número !", Toast.LENGTH_SHORT).show();
                    binding.txtDescricao.setText("");
                    binding.imgTubo.setBackgroundResource(0);
                    binding.imgS.setBackgroundResource(0);

                } else {

                    Escalar_Ph_model model = Util_Escalar_Ph.getEscalarPhModel(numero);
                    binding.txtDescricao.setText(model.getDescricao());
                    binding.imgTubo.setBackgroundResource(model.getImgTuboResource());
                    binding.imgS.setBackgroundResource(model.getImgSResource());

                }
            }
        });

        return view;
    }

}