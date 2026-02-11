package com.example.djpanda.data;
import com.example.djpanda.R;
import com.example.djpanda.models.Party;
import com.example.djpanda.models.Dj_model;
import java.util.ArrayList;
import com.example.djpanda.models.Review;

public class AppData {
    public static final ArrayList<Party> parties = new ArrayList<>();
    // 1- Trance, 2- Techno, 3- HipHop, 4- Pop, 5- Latin
    public static final ArrayList<Dj_model> djs = new ArrayList<>();
    //Djs: 1- Dj Panda, 2- Dj Timmy, 3- Dj Hippo, 4- Dj Superstar, 5- Dj Shakira

    static {
        // קטגוריות: Pop, 80s, Rockstar, Techno

// Techno (3)
        parties.add(new Party(
                1,
                "Warehouse Techno",
                "Techno",
                R.drawable.techno_party1,
                "20/02/2026",
                "02:00",
                "Terminal X",
                "Tel Aviv",
                1,
                "Techno",
                160.0, 140.0, 120.0, 105.0,
                "15/01/2026",
                21,
                "A true warehouse techno night with heavy bass and dark vibes."
        ));

        parties.add(new Party(
                2,
                "Neon Tech Sessions",
                "Techno",
                R.drawable.techno_party2,
                "07/02/2026",
                "01:00",
                "Underground Dock",
                "Haifa",
                6,
                "Techno",
                150.0, 130.0, 110.0, 95.0,
                "04/02/2026",
                18,
                "Futuristic techno set with Dj Neon and a powerful sound system."
        ));

        parties.add(new Party(
                3,
                "Techno After Hours",
                "Techno",
                R.drawable.techno_party3,
                "22/02/2026",
                "02:00",
                "Concrete Room",
                "Tel Aviv",
                2,
                "Techno",
                140.0, 120.0, 105.0, 90.0,
                "20/02/2026",
                18,
                "Late-night techno for real dancers. Deep, driving, nonstop."
        ));

// Pop (3)
        parties.add(new Party(
                4,
                "Mainstream Saturday",
                "Pop",
                R.drawable.pop_party1,
                "01/02/2026",
                "23:30",
                "Sky Bar",
                "Tel Aviv",
                5,
                "Pop",
                130.0, 110.0, 95.0, 80.0,
                "28/01/2026",
                18,
                "Big hits, sing-along anthems, and high energy all night."
        ));

        parties.add(new Party(
                5,
                "Pop Glow Party",
                "Pop",
                R.drawable.pop_party2,
                "21/02/2026",
                "22:00",
                "Rooftop Arena",
                "Ramat Gan",
                4,
                "Pop",
                135.0, 115.0, 95.0, 85.0,
                "12/02/2026",
                18,
                "Pop remixes, bright vibes, and a packed dance floor."
        ));

        parties.add(new Party(
                6,
                "Chart Hits Night",
                "Pop",
                R.drawable.pop_party3,
                "28/02/2026",
                "22:30",
                "City Club",
                "Holon",
                6,
                "Pop",
                120.0, 105.0, 90.0, 75.0,
                "25/02/2026",
                18,
                "All the latest chart hits in one night. No breaks, just fun."
        ));

// 80s (3)
        parties.add(new Party(
                7,
                "80s Retro Night",
                "80s",
                R.drawable.old_music_party1,
                "09/02/2026",
                "21:30",
                "Retro Hall",
                "Tel Aviv",
                5,
                "80s Pop",
                110.0, 95.0, 85.0, 70.0,
                "07/02/2026",
                18,
                "Classic 80s hits, retro vibes, and nonstop nostalgia."
        ));

        parties.add(new Party(
                8,
                "Back To The 80s",
                "80s",
                R.drawable.old_music_party2,
                "20/02/2026",
                "22:00",
                "Flash Club",
                "Rishon LeZion",
                3,
                "80s Classics",
                115.0, 100.0, 85.0, 75.0,
                "18/02/2026",
                18,
                "80s classics with a fun crowd and a warm nostalgic atmosphere."
        ));

        parties.add(new Party(
                9,
                "Retro Dance Floor",
                "80s",
                R.drawable.old_music_party3,
                "06/03/2026",
                "22:00",
                "Neon Ballroom",
                "Herzliya",
                1,
                "80s Dance",
                120.0, 105.0, 90.0, 80.0,
                "04/03/2026",
                18,
                "Big 80s choruses, dance remixes, and a happy vibe."
        ));

// Rockstar (3)
        parties.add(new Party(
                10,
                "Rockstar Night",
                "Rockstar",
                R.drawable.rock_party1,
                "13/02/2026",
                "22:30",
                "Guitar Club",
                "Tel Aviv",
                6,
                "Rock Classics",
                125.0, 110.0, 95.0, 80.0,
                "11/02/2026",
                18,
                "Rock anthems, loud energy, and a crowd that sings every chorus."
        ));

        parties.add(new Party(
                11,
                "Legends Of Rock",
                "Rockstar",
                R.drawable.rock_party2,
                "27/02/2026",
                "20:00",
                "Stage House",
                "Haifa",
                2,
                "Rock",
                130.0, 115.0, 100.0, 85.0,
                "25/02/2026",
                18,
                "A night of classic rock legends and heavy sing-along moments."
        ));

        parties.add(new Party(
                12,
                "Rock & Dance",
                "Rockstar",
                R.drawable.rock_party3,
                "08/03/2026",
                "22:00",
                "Pulse Arena",
                "Holon",
                3,
                "Rock Mix",
                120.0, 105.0, 90.0, 75.0,
                "06/03/2026",
                18,
                "Rock vibes with dance energy. Fast, fun, and loud."
        ));


        djs.add(new Dj_model(
                1,
                "Dj Panda",
                R.drawable.dj_panda,
                "Pop • Techno • 80s • Rockstar",
                "Tel Aviv | Ramat Gan",
                "Fueling the dance floor with pure adrenaline!\nKnown for high-energy trance sets,\nDj Panda masters the art of the Trance.\n"+
                        "If you’re looking for a nonstop journey through uplifting melodies and heart-pounding beats, you’re in the right place.",
                4.6,
                128,
                new Review("Avi Ron.", "The best trance set I've ever heard! The drops were insane.", 5.0f)
        ));

        djs.add(new Dj_model(
                2,
                "Dj Timmy",
                R.drawable.dj_timmy,
                "Techno • House • Rock",
                "Tel Aviv | Herzliya",
                "The king of the underground!\nDj Timmy brings the raw energy of warehouse techno straight to the booth.\n" +
                        "Expect deep, driving grooves, heavy basslines, and a dark, industrial atmosphere that keeps the crowd moving in a trance-like state until the early morning hours.",
                4.4,
                92,
                new Review("Eli Kopter.", "Proper underground techno vibes. The bass was hitting hard!", 4.5f)
        ));

        djs.add(new Dj_model(
                3,
                "Dj Hippo",
                R.drawable.dj_hippo,
                "HipHop • Techno",
                "Rishon LeZion | Bat Yam",
                "Where smooth meets hype.\nDj Hippo is a master of crowd control, seamlessly blending old-school R&B soul with the freshest hip-hop bangers.\n"+
                        "From the soulful warmup to the peak-time energy, he knows exactly how to keep the vibe electric and the hands in the air.",
                4.2,
                56,
                new Review("Amit Nakesh", "Perfect mix of R&B and HipHop. Dj Hippo really knows how to control the crowd.", 4.0f)
        ));

        djs.add(new Dj_model(
                4,
                "Dj Superstar",
                R.drawable.dj_superstar,
                "Pop",
                "Holon",
                "Your soundtrack to the perfect night out!\nDj Superstar specializes in pure energy and sing-along anthems."+"\nMixing the biggest global chart-toppers with high-octane dance remixes, she ensures that every moment on the floor is a 'hands-in-the-air' confetti moment.",
                4.7,
                210,
                new Review("Eden Shoulders", "The best pop party in town! Sing-along anthems from start to finish.", 5.0f)
        ));

        djs.add(new Dj_model(
                5,
                "Dj Shakira",
                R.drawable.dj_shakira,
                "Pop • Rock • Techno • Dance • Reggaeton",
                "Tel Aviv | Holon | Rishon LeZion",
                "A global party experience in one DJ!\n" +
                        "Dj Shakira is known for her incredible versatility and ability to move seamlessly between styles.\n" +
                        "From pop anthems and Latin heat to hip-hop grooves and nonstop dance hits,\n" +
                        "she reads the crowd perfectly and keeps the energy high from start to finish.",
                4.8,
                245,
                new Review(
                        "Maya Levi",
                        "Unreal energy! She played everything we wanted and the dance floor was on fire all night.",
                        5.0f
                )
        ));


        djs.add(new Dj_model(
                6,
                "Dj Neon",
                R.drawable.dj_neon, // ודאי שיש לך תמונה בשם זה בתיקיית drawable
                "Techno • House • Pop ",
                "Haifa | Caesarea",
                "Illuminating the night with electric pulses and deep bass.\n" +
                        "Dj Neon creates an immersive audiovisual experience that transcends the ordinary.\n" +
                        "Known for futuristic soundscapes and a relentless energy that keeps the dance floor glowing until the early hours of the morning.",
                4.8,
                215,
                new Review("Orly Light", "Incredible atmosphere! The lighting and the drops were out of this world.", 5.0f)
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
    public static Dj_model getDjById(int id) {
        for (Dj_model d : djs) {
            if (d.id == id) {
                return d;
            }
        }
        return null;
    }

}
