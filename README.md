### Payload example

#### Partner
```
{
    "name": "Joselino Aquile",
    "email": "joselinoaqlcna@gmail.com",
    "password": "josesinho",
    "documentId": "509920283718",
    "fidelity": "false",
    "phoneNumber": "(11)9827818727",
    "numberOfCampaigns": 8 
}
```

#### PetTutor
```
{
    "name": "Heloísio Bitencourt",
    "email": "h.bitencourt@gmail.com",
    "password": "helisinho",
    "documentId": "610031394829",
    "phone_number": "(22)9938929822"
}
```

#### Pet
```
{
    "name": "Rex",
    "specie": "Dog",
    "breed": "Pooch",
    "birthdate": "2018-01-01",
    "healthDescription": "Shampoo for dermatitis",
    "petTutor":  {
      "petTutorId": 1
      }
}
```

### Hotel
````
{
  "name": "wall teste",
  "email": "wall@teste",
  "password": "12345678",
  "documentId": "1442232",
  "fidelity": false,
  "planType": "gold",
  "rates": 0.7,
  "phoneNumber": "1122334455"
}
````

### ServicesProvided

````
{
    "service_pool": true,
    "service_playground": true,
    "service_toys": true,
    "service_bath": true,
    "service_leathering": true,
    "service_bedroom": true,
    "service_food": true,
    "service_visitation": true,
    "service_cam": true,
    "service_exercises": true,
    "service_training": true,
    "service_dentist": true,
    "service_vet": true,
    "service_monitoring": true,
    "hotel": {
        "hotelId": 1
        }
}
````

#### Campaign
```
{
    "type": "Gold",
    "value": "6000.00",
    "click": 16000,
    "startedAt": "2022-09-29",
    "finishedAt": "2022-10-29",
    "partner": {
      "partnerId": 1
      }
}
```

#### Plan
```
{
    "planType": "Gold",
    "planValue": 350.00,
    "hotel": {
      "hotelId": 1
      }
}
```

#### Pet Tutor Address
```
{
    "addressCode": "04136-111",
    "addressStreet": "Rua Samambaia",
    "addressNumber": "700",
    "addressComplement": "",
    "addressDistrict": "Bosque da Saúde",
    "addressCity": "São Paulo",
    "addressState": "São Paulo",
    "petTutor":  {
      "petTutorId": 1
      }
}
```