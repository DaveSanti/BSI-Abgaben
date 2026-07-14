package com.example.mycologneapp.data

import androidx.compose.ui.graphics.Color
import com.example.mycologneapp.model.ColognePlace
import com.example.mycologneapp.model.PlaceCategory

object CologneDataSource {
    val categories = listOf(
        PlaceCategory(
            id = "landmarks",
            name = "Wahrzeichen",
            description = "Klassische Orte, die Köln sofort erkennbar machen.",
            color = Color(0xFF006B7F)
        ),
        PlaceCategory(
            id = "parks",
            name = "Parks & Rhein",
            description = "Grüne Orte, Wasserblicke und entspannte Spaziergänge.",
            color = Color(0xFF4F7C35)
        ),
        PlaceCategory(
            id = "museums",
            name = "Kultur",
            description = "Museen, Geschichte und besondere Innenräume.",
            color = Color(0xFF8A4A25)
        ),
        PlaceCategory(
            id = "food",
            name = "Essen & Cafés",
            description = "Orte für eine Pause zwischen Stadt und Rhein.",
            color = Color(0xFF9B3D4A)
        )
    )

    val places = listOf(
        ColognePlace(
            id = "dom",
            categoryId = "landmarks",
            name = "Kölner Dom",
            district = "Altstadt-Nord",
            shortDescription = "Das zentrale Wahrzeichen direkt am Hauptbahnhof.",
            details = "Der Dom ist der beste Startpunkt für eine Köln-Tour. Von hier aus sind Rhein, Altstadt, Museen und Einkaufsstraßen gut erreichbar.",
            bestFor = "Erster Stadtrundgang, Architektur, Aussicht vom Turm",
            latitude = 50.9413,
            longitude = 6.9583
        ),
        ColognePlace(
            id = "hohenzollern",
            categoryId = "landmarks",
            name = "Hohenzollernbrücke",
            district = "Innenstadt / Deutz",
            shortDescription = "Rheinbrücke mit Blick auf Dom und Altstadt.",
            details = "Die Brücke verbindet Domseite und Deutz. Besonders abends lohnt sich der Weg wegen der Skyline und der Lichter am Rhein.",
            bestFor = "Fotos, Sonnenuntergang, kurzer Spaziergang",
            latitude = 50.9422,
            longitude = 6.9651
        ),
        ColognePlace(
            id = "rheinauhafen",
            categoryId = "landmarks",
            name = "Rheinauhafen",
            district = "Altstadt-Süd",
            shortDescription = "Moderne Rheinpromenade mit Kranhäusern.",
            details = "Der Rheinauhafen zeigt Köln moderner: breite Wege, Wasserblick, Architektur und viele kleine Stopps entlang der Promenade.",
            bestFor = "Architektur, Spaziergang, Rheinblick",
            latitude = 50.9264,
            longitude = 6.9638
        ),
        ColognePlace(
            id = "flora",
            categoryId = "parks",
            name = "Flora & Botanischer Garten",
            district = "Riehl",
            shortDescription = "Ruhiger Garten mit historischen Anlagen.",
            details = "Die Flora ist ideal, wenn die Innenstadt zu voll ist. Sie kombiniert Parkwege, Gewächshäuser und ruhige Ecken.",
            bestFor = "Ruhige Pause, Pflanzen, Spaziergang",
            latitude = 50.9591,
            longitude = 6.9713
        ),
        ColognePlace(
            id = "rheinpark",
            categoryId = "parks",
            name = "Rheinpark",
            district = "Deutz",
            shortDescription = "Großer Park auf der rechten Rheinseite.",
            details = "Der Rheinpark bietet viel Platz und einen starken Blick zur Altstadt. Von hier aus führt ein guter Weg zur Seilbahn oder Richtung Messe.",
            bestFor = "Picknick, Familien, Skyline-Blick",
            latitude = 50.9468,
            longitude = 6.9824
        ),
        ColognePlace(
            id = "stadtwald",
            categoryId = "parks",
            name = "Stadtwald",
            district = "Lindenthal",
            shortDescription = "Großer Grünraum im Westen der Stadt.",
            details = "Der Stadtwald eignet sich für einen längeren Ausflug abseits der Innenstadt. Wege, Wiesen und Wasser machen ihn sehr entspannt.",
            bestFor = "Lange Spaziergänge, Joggen, Auszeit",
            latitude = 50.9328,
            longitude = 6.8892
        ),
        ColognePlace(
            id = "museum-ludwig",
            categoryId = "museums",
            name = "Museum Ludwig",
            district = "Altstadt-Nord",
            shortDescription = "Moderne Kunst direkt neben dem Dom.",
            details = "Das Museum Ludwig passt perfekt in eine Innenstadt-Route. Es ist zentral gelegen und bietet einen guten Kontrast zur historischen Altstadt.",
            bestFor = "Moderne Kunst, Regentage, Innenstadt-Tour",
            latitude = 50.9407,
            longitude = 6.9599
        ),
        ColognePlace(
            id = "schokoladenmuseum",
            categoryId = "museums",
            name = "Schokoladenmuseum",
            district = "Rheinauhafen",
            shortDescription = "Museum am Rhein mit Blick in die Produktion.",
            details = "Das Schokoladenmuseum liegt direkt am Wasser und funktioniert gut als Ziel für Gruppen, Familien oder eine entspannte Tour am Rhein.",
            bestFor = "Familien, Schokolade, Rheinauhafen",
            latitude = 50.9312,
            longitude = 6.9641
        ),
        ColognePlace(
            id = "ns-dok",
            categoryId = "museums",
            name = "NS-Dokumentationszentrum",
            district = "Altstadt-Nord",
            shortDescription = "Wichtiger historischer Lernort in der Innenstadt.",
            details = "Das EL-DE-Haus ist ein ernster, aber sehr wichtiger Ort. Es zeigt Stadtgeschichte und Verantwortung sehr direkt.",
            bestFor = "Geschichte, Bildung, ruhige Besichtigung",
            latitude = 50.9383,
            longitude = 6.9509
        ),
        ColognePlace(
            id = "belgisches",
            categoryId = "food",
            name = "Belgisches Viertel",
            district = "Neustadt-Nord",
            shortDescription = "Viele Cafés, Bars und kleine Restaurants.",
            details = "Das Belgische Viertel ist gut für eine flexible Pause: Kaffee am Nachmittag, Abendessen oder ein kurzer Bummel durch kleinere Läden.",
            bestFor = "Café, Abendessen, Freundesgruppe",
            latitude = 50.9395,
            longitude = 6.9375
        ),
        ColognePlace(
            id = "suedstadt",
            categoryId = "food",
            name = "Südstadt",
            district = "Neustadt-Süd",
            shortDescription = "Lockere Veedel-Atmosphäre mit vielen Lokalen.",
            details = "Die Südstadt wirkt weniger touristisch und ist gut, wenn man Köln als Veedelstadt erleben möchte.",
            bestFor = "Lokale Küche, entspannter Abend, Veedel-Gefühl",
            latitude = 50.9215,
            longitude = 6.9594
        ),
        ColognePlace(
            id = "ehrenfeld",
            categoryId = "food",
            name = "Ehrenfeld",
            district = "Ehrenfeld",
            shortDescription = "Kreatives Viertel mit Streetfood und Cafés.",
            details = "Ehrenfeld eignet sich für eine Tour außerhalb der klassischen Innenstadt. Cafés, Imbisse, Kulturorte und Streetart liegen nah beieinander.",
            bestFor = "Streetfood, Cafés, alternative Orte",
            latitude = 50.9512,
            longitude = 6.9169
        )
    )

    fun defaultCategory(): PlaceCategory = categories.first()

    fun defaultPlace(): ColognePlace = places.first()

    fun placesFor(categoryId: String): List<ColognePlace> =
        places.filter { it.categoryId == categoryId }

    fun categoryFor(categoryId: String): PlaceCategory =
        categories.firstOrNull { it.id == categoryId } ?: defaultCategory()

    fun placeFor(placeId: String): ColognePlace =
        places.firstOrNull { it.id == placeId } ?: defaultPlace()
}
