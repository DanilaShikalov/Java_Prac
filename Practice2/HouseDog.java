package com.company.Practice2;


public class HouseDog {
        private Dog[] Massiv = new Dog[10];
        private int t = 0;

        public void DogHouse(Dog dog) {
            Massiv[t] = dog;
            t++;
            System.out.println("Принято");
        }
}
