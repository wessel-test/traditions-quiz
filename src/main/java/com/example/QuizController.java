package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class QuizController {
    private static final Map<String, List<String>> traditions = new HashMap<>();

    static {
        // Traditions from Brazil
        traditions.put("Brazil", Arrays.asList(
            "This country has a famous festival where everyone dances samba, and it lasts for days—if you can't dance, you might as well stay home!",
            "It has a unique way to reduce prison sentences: by reading books. Four days off for each book—who knew jail could be so literary?",
            "The national dish is a hearty stew made with black beans and pork, so if you miss it, you might be in hot water!",
            "You can find pink dolphins swimming in its rivers—because who doesn’t love a splash of color?",
            "This place has the largest population of Japanese people outside Japan, making sushi a beloved local cuisine.",
            "It boasts over 4,600 miles of coastline, perfect for beach lovers and sunbathers alike.",
            "The capital city was designed to look like an airplane from above—talk about a city with wings!",
            "This country has a tropical rainforest that produces more oxygen than any other place on Earth—nature’s very own air freshener!",
            "It’s known for its warm hospitality and love for celebrations; if you're not dancing, you're doing it wrong!",
            "The country has three time zones—so if you're late, just blame it on the clock!",
            "It has the world's largest tropical wetland, teeming with wildlife—perfect for nature enthusiasts.",
            "The highest point in this country was only discovered in the 1950s—fashionably late to the mountain party!",
            "It has more than 400 airports, making it easy to fly just about anywhere.",
            "This nation has won the FIFA World Cup five times, making it the ultimate soccer superstar.",
            "You can reduce your prison sentence by reading books—four days off for each one read. Who knew prison could be so educational?",
            "The flag features 27 stars representing its states—a celestial map of sorts!",
            "It's home to some of the most diverse ecosystems on the planet, with millions of species yet to be discovered.",
            "There are more than 60 national parks here, showcasing stunning natural beauty and wildlife.",
            "This country is known for its vibrant street art scene—where walls become canvases for creativity!",
            "It has a unique blend of cultures that makes its food scene incredibly diverse and delicious!"
        ));

        // Traditions from Germany
        traditions.put("Germany", Arrays.asList(
            "This country is famous for its beer gardens, where people gather to enjoy brews and hearty snacks—cheers to that!",
            "It has a unique tradition of Christmas markets that are filled with festive lights, mulled wine, and handmade crafts—perfect for holiday shopping!",
            "They have the longest highway in the world, which has sections with no speed limit—so you can really put the pedal to the metal!",
            "This nation is known for its delicious sausages, with over 1,000 varieties to choose from—meat lovers will feel right at home!",
            "It boasts more zoos than any other country, making it a paradise for animal enthusiasts—so many furry friends to meet!",
            "The capital city features an iconic wall that once divided the nation but is now a symbol of unity—history is alive here!",
            "This country has a rich tradition of fairy tales, with many stories originating from its regions—think of it as a real-life storybook land!",
            "The locals celebrate Oktoberfest, the world's largest beer festival, where everyone dons traditional costumes and enjoys giant pretzels—prost!",
            "It is home to thousands of castles scattered throughout the countryside—perfect for anyone dreaming of being a prince or princess!",
            "This country has a unique custom where people hang lost items on trees as part of a quirky tradition—talk about recycling!",
            "The first printed book in history was produced here, making it a pioneer in literature and publishing.",
            "This nation has a strong recycling culture and is known for its effective waste management systems—going green is taken seriously!",
            "It features the world's largest wine barrel that can hold over 58,000 gallons of wine—a true wine lover's dream come true!",
            "The locals have a tradition called 'Polterabend,' where guests break porcelain at weddings to bring luck to the couple—talk about smashing fun!",
            "This country celebrates Carnival with vibrant parades and colorful costumes; let the festivities begin!",
            "It has one of the highest numbers of Michelin-starred restaurants in the world—fine dining is taken to another level here!",
            "The narrowest street in the world can be found here, measuring just 31 centimeters wide—a real squeeze for pedestrians!",
            "With over 3,000 types of bread available, this nation takes its carbs seriously—bread lovers will be in heaven!",
            "This country was the first to adopt daylight saving time back in 1916—always ahead of the curve when it comes to timekeeping!",
            "It has a strong emphasis on order and cleanliness, reflected in customs like 'Kehrwoche,' where residents take turns cleaning public spaces!"
        ));
    }

    @GetMapping("/tradition")
    public Map<String, String> getRandomTradition() {
        Random random = new Random();
        String country = (String) traditions.keySet().toArray()[random.nextInt(traditions.size())];
        List<String> countryTraditions = traditions.get(country);
        String tradition = countryTraditions.get(random.nextInt(countryTraditions.size()));
        
        Map<String, String> response = new HashMap<>();
        response.put("tradition", tradition);
        response.put("country", country); // Send correct country for validation
        return response;
    }

    @PostMapping("/guess")
    public String checkGuess(@RequestParam String guess, @RequestParam String correctCountry) {
        if (guess.equalsIgnoreCase(correctCountry)) {
            return "Correct!";
        } else {
            return "Wrong! It was from " + correctCountry + ".";
        }
    }
}
