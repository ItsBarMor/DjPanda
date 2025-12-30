package com.example.djpanda.data;
import com.example.djpanda.R;
import com.example.djpanda.models.Party;
import com.example.djpanda.models.Dj;
import java.util.ArrayList;
public class AppData {
    public static final ArrayList<Party> parties = new ArrayList<>();
    // 1- Trance, 2- Techno, 3- HipHop, 4- Pop, 5- Latin
    public static final ArrayList<Dj> djs = new ArrayList<>();
    //Djs: 1- Dj Panda, 2- Dj Timmy, 3- Dj Hippo, 4- Dj Superstar, 5- Dj Shakira

    static {
        //Trance
        parties.add(new Party(
                1,
                "Trance Night TLV",
                "Trance",
                R.drawable.party_trance_night_tlv,
                "12/01/2026",
                "23:00",
                "Haoman 17",
                "Tel Aviv",
                1,
                "Trance",
                120.0,
                110.0,
                100.0,
                90.0,
                "10/01/2026",
                18,
                "Trance Night TLV is back at Haoman 17 with the one and only: \nDj Panda!!!\n"
                +"Two dance floors, uplifting & progressive trance all night, and a crowd that comes for pure energy.\n" +
                        "Expect big builds, clean drops, and a nonstop vibe until sunrise!"

        ));

        //Techno
        parties.add(new Party(
                2,
                "Warehouse Techno",
                "Techno",
                R.drawable.party_warehouse_techno,
                "18/01/2026",
                "00:30",
                "Terminal X",
                "Tel Aviv",
                2,
                "Techno",
                160.0,
                140.0,
                120.0,
                105.0,
                "15/01/2026",
                21,
                "Step into Terminal X for a true warehouse techno experience:\n raw industrial vibes, deep shadows, pounding kicks, and a sound system built for pressure!\n" +
                        "From driving techno to harder peak-time moments, this one goes all the way!"
        ));

        //HipHop
        parties.add(new Party(
                3,
                "Urban Friday",
                "HipHop",
                R.drawable.party_urban_friday,
                "24/01/2026",
                "22:30",
                "Club Pulse",
                "Rishon LeZion",
                3,
                "HipHop",
                120.0,
                100.0,
                90.0,
                75.0,
                "20/01/2026",
                18,
                "Urban Friday at Club Pulse brings the perfect mix of hip-hop and R&B!\nSmooth warmup vibes, sing-along hooks, and a packed dance floor all night :)\n"+
                        "Expect throwbacks, current bangers, and a crowd that knows the words!\nSee you soon!"
        ));

        //Pop
        parties.add(new Party(
                4,
                "Mainstream Saturday",
                "Pop",
                R.drawable.party_mainstream_saturday,
                "01/02/2026",
                "23:30",
                "Sky Bar",
                "Tel Aviv",
                4,
                "Pop",
                130.0,
                110.0,
                95.0,
                80.0,
                "28/01/2026",
                18,
                "Mainstream Saturday at Sky Bar is all about big hits and bigger energy!\n"+
                        "The latest chart-toppers, dance anthems, and a high-production party vibe.\n" +
                        "Expect confetti moments, hands-in-the-air drops, and a packed floor from start to finish!"
        ));

        //Latin
        parties.add(new Party(
                5,
                "Latin Hit",
                "Latin",
                R.drawable.party_latin_hit,
                "08/02/2026",
                "22:00",
                "La Casa",
                "Holon",
                5,
                "Latin",
                125.0,
                105.0,
                85.0,
                70.0,
                "05/02/2026",
                18,
                "Latin Hit at La Casa brings the heat with Dj Shakira!!!\n" + "Reggaeton, Latin hits, and nonstop rhythm all night.\n"+
                        "Start with a fun warm-up early on, then ride the energy as the dance floor turns into a full Latin fiesta!"
        ));

        djs.add(new Dj(
                1,
                "Dj Panda",
                R.drawable.dj_panda,
                "Trance",
                "Tel Aviv | Ramat Gan",
                "High energy trance sets with clean builds and big drops",
                4.6,
                128
        ));

        djs.add(new Dj(
                2,
                "Dj Timmy",
                R.drawable.dj_timmy,
                "Techno",
                "Tel Aviv | Herzliya",
                "Warehouse vibes, heavy bass, and long driving grooves",
                4.4,
                92
        ));

        djs.add(new Dj(
                3,
                "Dj Hippo",
                R.drawable.dj_hippo,
                "HipHop",
                "Rishon LeZion | Bat Yam",
                "Smooth R&B into hype hip-hop, great crowd control",
                4.2,
                56
        ));

        djs.add(new Dj(
                4,
                "Dj Superstar",
                R.drawable.dj_superstar,
                "Pop",
                "Holon",
                "Mainstream party anthems and sing-along moments all night",
                4.7,
                210
        ));

        djs.add(new Dj(
                5,
                "Dj Shakira",
                R.drawable.dj_shakira,
                "Latin",
                "Holon | Tel Aviv",
                "Latin rhythm, reggaeton heat, and a fun warmup set early",
                4.5,
                143
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
    public static Dj getDjById(int id) {
        for (Dj d : djs) {
            if (d.id == id) {
                return d;
            }
        }
        return null;
    }

}
