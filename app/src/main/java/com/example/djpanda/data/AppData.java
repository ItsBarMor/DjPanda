package com.example.djpanda.data;
import com.example.djpanda.R;
import com.example.djpanda.models.Party;
import java.util.ArrayList;
public class AppData {
    public static final ArrayList<Party> parties = new ArrayList<>();
    // 1- Trance, 2- Techno, 3- HipHop, 4- Pop, 5- Latin
    static {
        //Trance
        parties.add(new Party(
                1,
                "Trance Night TLV",
                "Trance",
                R.drawable.ic_launcher_background,
                "12/01/2026",
                "23:00",
                "Haoman 17",
                "Tel Aviv",
                "Dj Panda",
                "Trance • Progressive",
                140.0,
                120.0,
                110.0,
                90.0,
                "10/01/2026",
                18,
                "Trance night with 2 dance floors, strong lineup, and an insane vibe all night long!"
        ));

        //Techno
        parties.add(new Party(
                2,
                "Warehouse Techno",
                "Techno",
                R.drawable.ic_launcher_background,
                "18/01/2026",
                "00:30",
                "Terminal X",
                "Tel Aviv",
                "Dj Timmy",
                "Techno • Hard Techno",
                160.0,
                140.0,
                120.0,
                105.0,
                "15/01/2026",
                21,
                "Industrial warehouse techno party with heavy bass, dark atmosphere, and non-stop energy :)"
        ));

        //HipHop
        parties.add(new Party(
                3,
                "Urban Friday",
                "HipHop",
                R.drawable.ic_launcher_background,
                "24/01/2026",
                "22:30",
                "Club Pulse",
                "Rishon LeZion",
                "Dj Hippo",
                "HipHop • R&B",
                120.0,
                100.0,
                90.0,
                75.0,
                "20/01/2026",
                18,
                "Hip-hop and R&B night with a smooth vibe, dance battles, and the best throwback hits"
        ));

        //Pop
        parties.add(new Party(
                4,
                "Mainstream Saturday",
                "Pop",
                R.drawable.ic_launcher_background,
                "01/02/2026",
                "23:30",
                "Sky Bar",
                "Tel Aviv",
                "Dj Roni Superstar",
                "Pop • Dance • Hits",
                130.0,
                110.0,
                95.0,
                80.0,
                "28/01/2026",
                18,
                "Big mainstream party with the latest hits, confetti drops, and a high-production show vibe"
        ));

        //Latin
        parties.add(new Party(
                5,
                "Latin Hit",
                "Latin",
                R.drawable.ic_launcher_background,
                "08/02/2026",
                "22:00",
                "La Casa",
                "Holon",
                "Dj Shakira",
                "Reggaeton • Latin",
                125.0,
                105.0,
                85.0,
                70.0,
                "05/02/2026",
                18,
                "Latin & reggaeton party with dance warmup early in the night and nonstop rhythm later on"
        ));
    }

    public static Party getPartyById(int id) {
        for (Party p : parties) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }
}
