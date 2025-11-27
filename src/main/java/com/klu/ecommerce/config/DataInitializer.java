package com.klu.ecommerce.config;

import com.klu.ecommerce.entity.Product;
import com.klu.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            productRepository.deleteAll();

            // Fruits
            productRepository.save(new Product("Mango", "fruits", 30.0, "mango.jpg"));
            productRepository.save(new Product("Apple", "fruits", 25.0, "apple.jpg"));
            productRepository.save(new Product("Banana", "fruits", 15.0, "banana.jpg"));
            productRepository.save(new Product("Grapes", "fruits", 40.0, "grapes.jpg"));
            productRepository.save(new Product("Kiwi", "fruits", 50.0, "kiwi.jpg"));
            productRepository.save(new Product("Orange", "fruits", 20.0, "orange.jpg"));
            productRepository.save(new Product("Peach", "fruits", 35.0, "peach.jpg"));
            productRepository.save(new Product("Pineapple", "fruits", 60.0, "pineapple.jpg"));
            productRepository.save(new Product("Strawberry", "fruits", 45.0, "strawberry.jpg"));
            productRepository.save(new Product("Watermelon", "fruits", 25.0, "watermelon.jpg"));


            // Crops
            productRepository.save(new Product("Wheat", "crops", 20.0, "wheat.jpg"));
            productRepository.save(new Product("Rice", "crops", 18.5, "rice.jpg"));
            productRepository.save(new Product("Corn", "crops", 22.0, "corn.jpg"));
            productRepository.save(new Product("Barley", "crops", 19.0, "barley.jpg"));
            productRepository.save(new Product("Soybean", "crops", 24.0, "soybean.jpg"));

            // Vegetables
            productRepository.save(new Product("Onion", "vegetables", 13.5, "onion.jpg"));
            productRepository.save(new Product("Carrot", "vegetables", 14.0, "carrot.jpg"));
            productRepository.save(new Product("Cabbage", "vegetables", 16.0, "cabbage.jpg"));
            productRepository.save(new Product("Cauliflower", "vegetables", 18.0, "cauliflower.jpg"));
            productRepository.save(new Product("Peas", "vegetables", 13.0, "peas.jpg"));
            productRepository.save(new Product("Spinach", "vegetables", 11.5, "spinach.jpg"));
            productRepository.save(new Product("Bell Pepper", "vegetables", 17.0, "bellpepper.jpg"));
            productRepository.save(new Product("Radish", "vegetables", 12.5, "radish.jpg"));
            productRepository.save(new Product("Broccoli", "vegetables", 19.0, "broccoli.jpg"));
            productRepository.save(new Product("Green Beans", "vegetables", 14.5, "greenbeans.jpg"));
            productRepository.save(new Product("Tomato", "vegetables", 15.0, "tomato.jpg"));
            productRepository.save(new Product("Potato", "vegetables", 12.0, "potato.jpg"));
            productRepository.save(new Product("Barley", "grains", 35.0, "barley.jpg"));
            productRepository.save(new Product("Oats", "grains", 50.0, "oats.jpg"));
            productRepository.save(new Product("Rye", "grains", 40.0, "rye.jpg"));

            productRepository.save(new Product("Moong Dal", "grains", 90.0, "moongdal.jpg"));
            productRepository.save(new Product("Chana Dal", "grains", 80.0, "chanadal.jpg"));
            productRepository.save(new Product("Masoor Dal", "grains", 85.0, "masoordal.jpg"));

            productRepository.save(new Product("Milk", "dairy", 25.0, "milk.jpg"));
            productRepository.save(new Product("Paneer", "dairy", 180.0, "paneer.jpg"));
            productRepository.save(new Product("Ghee", "dairy", 675.0, "ghee.jpg"));
            productRepository.save(new Product("Butter", "dairy", 120.0, "butter.jpg"));
            productRepository.save(new Product("Curd", "dairy", 50.0, "curd.jpg"));
            productRepository.save(new Product("Cheese", "dairy", 200.0, "cheese.jpg"));
            productRepository.save(new Product("Sweets", "dairy", 150.0, "sweets.jpg")); // generic sweets
            productRepository.save(new Product("Rabri", "dairy", 130.0, "rabri.jpg"));
            productRepository.save(new Product("Lassi", "dairy", 60.0, "lassi.jpg"));
            productRepository.save(new Product("Spinach", "herbs", 15.0, "spinach.jpg"));
            productRepository.save(new Product("Coriander", "herbs", 12.0, "coriander.jpg"));
            productRepository.save(new Product("Mint", "herbs", 10.0, "mint.jpg"));
            productRepository.save(new Product("Basil", "herbs", 20.0, "basil.jpg"));
            productRepository.save(new Product("Fenugreek", "herbs", 18.0, "fenugreek.jpg"));
            productRepository.save(new Product("Sorrel", "herbs", 14.0, "sorrel.jpg"));
            productRepository.save(new Product("Dill", "herbs", 16.0, "dill.jpg"));
            productRepository.save(new Product("Thotakura", "herbs", 16.0, "thotakura.jpg"));
            productRepository.save(new Product("Gongura", "herbs", 17.0, "gongura.jpg"));
            productRepository.save(new Product("Parsley", "herbs", 15.0, "parsley.jpg"));
            productRepository.save(new Product("Chives", "herbs", 13.0, "chives.jpg"));
            productRepository.save(new Product("Rosemary", "herbs", 25.0, "rosemary.jpg"));
            productRepository.save(new Product("Thyme", "herbs", 22.0, "thyme.jpg"));
            productRepository.save(new Product("Oregano", "herbs", 20.0, "oregano.jpg"));
            productRepository.save(new Product("Broiler Chicken", "poultry", 120.0, "broiler_chicken.jpg"));
            productRepository.save(new Product("Layer Chicken", "poultry", 150.0, "layer_chicken.jpg"));
            productRepository.save(new Product("Duck", "poultry", 180.0, "duck.jpg"));
            productRepository.save(new Product("Turkey", "poultry", 200.0, "turkey.jpg"));
            productRepository.save(new Product("Quail", "poultry", 220.0, "quail.jpg"));
            productRepository.save(new Product("Eggs", "poultry", 5.0, "eggs.jpg"));
            productRepository.save(new Product("Chives", "organic", 13.0, "chives.jpg"));
            productRepository.save(new Product("Rosemary", "organic", 25.0, "rosemary.jpg"));
            productRepository.save(new Product("Thyme", "organic", 22.0, "thyme.jpg"));
            productRepository.save(new Product("Oregano", "organic", 20.0, "oregano.jpg"));
            productRepository.save(new Product("Basil Seeds", "organic", 15.0, "basil_seeds.jpg"));
            productRepository.save(new Product("Fenugreek Seeds", "organic", 12.0, "fenugreek_seeds.jpg"));
            productRepository.save(new Product("Organic Compost", "organic", 50.0, "organic_compost.jpg"));
            productRepository.save(new Product("Neem Oil", "organic", 40.0, "neem_oil.jpg"));
            productRepository.save(new Product("Vermicompost", "organic", 35.0, "vermicompost.jpg"));
            productRepository.save(new Product("Herbal Pesticide", "organic", 45.0, "herbal_pesticide.jpg"));
            productRepository.save(new Product("Organic Mulch", "organic", 30.0, "organic_mulch.jpg"));
            productRepository.save(new Product("Spirulina Powder", "organic", 60.0, "spirulina_powder.jpg"));
            productRepository.save(new Product("Seaweed Extract", "organic", 55.0, "seaweed_extract.jpg"));
            productRepository.save(new Product("Mixed Fruit Jam", "agro_processed", 60.0, "mixed_fruit_jam.jpg"));
            productRepository.save(new Product("Mango Pickle", "agro_processed", 45.0, "mango_pickle.jpg"));
            productRepository.save(new Product("Dried Apricots", "agro_processed", 70.0, "dried_apricots.jpg"));
            productRepository.save(new Product("Organic Honey", "agro_processed", 80.0, "organic_honey.jpg"));
            productRepository.save(new Product("Tomato Sauce", "agro_processed", 35.0, "tomato_sauce.jpg"));
            productRepository.save(new Product("Fruit Cake", "agro_processed", 110.0, "fruit_cake.jpg"));
            productRepository.save(new Product("Wild Honey", "specialty_local", 100.0, "wild_honey.jpg"));
            productRepository.save(new Product("Handmade Jute Bags", "specialty_local", 150.0, "jute_bags.jpg"));
            productRepository.save(new Product("Organic Turmeric Powder", "specialty_local", 85.0, "turmeric_powder.jpg"));
            productRepository.save(new Product("Local Herbal Tea", "specialty_local", 40.0, "herbal_tea.jpg"));
            productRepository.save(new Product("Indigenous Rice", "specialty_local", 90.0, "indigenous_rice.jpg"));
            productRepository.save(new Product("Traditional Pickle", "specialty_local", 55.0, "traditional_pickle.jpg"));



            System.out.println("Sample products added to database!");
        };
    }
}
