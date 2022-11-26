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
  "name": "Pet Happy",
  "email": "pethappy@gmail.com",
  "password": "pethappy",
  "documentId": "22.948.845/0001-57",
  "phoneNumber": "1120056725",
  "description": "Uma descrição bem grande aqui com muitas e muitas palavras, formando várias e várias frases com limite de 512 caracteres"
}
````

### ServicesProvided

````
{
  "servicesProvided": {
    "servicePool": true,
    "servicePlayground": true,
    "serviceToys": true,
    "serviceBath": true,
    "serviceLeathering": true,
    "serviceBedroom": true,
    "serviceFood": true,
    "serviceVisitation": true,
    "serviceCam": true,
    "serviceExercises": true,
    "serviceTraining": true,
    "serviceDentist": true,
    "serviceVet": true,
    "serviceMonitoring": true,
    "dogsAcepted": true,
    "catsAcepted": true,
    "othersAcepted": true,
    "averagePrice": "Até R$ 200,00",
    "guestsNumber": 31,
    "hotel": {
      "hotelId": 6
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

#### Hotel Post AllFilds
```
{
  "campaign": {
    "type": "Bronze",
    "value": 2000.00,
    "click": 0,
    "hotel": {
      "hotelId": 6
    }
  },
  "plan": {
    "planType": "Bronze",
    "planValue": 150.00,
    "hotel": {
      "hotelId": 6
    }
  },
  "address": {
    "addressCode": "04137-111",
    "addressStreet": "Rua dos Eucaliptos",
    "addressNumber": "798",
    "addressDistrict": "Bosque da Saúde",
    "addressCity": "São Paulo",
    "addressState": "São Paulo",
    "hotel": {
      "hotelId": 6
    }
  },
  "servicesProvided": {
    "servicePool": true,
    "servicePlayground": true,
    "serviceToys": true,
    "serviceBath": true,
    "serviceLeathering": true,
    "serviceBedroom": true,
    "serviceFood": true,
    "serviceVisitation": true,
    "serviceCam": true,
    "serviceExercises": true,
    "serviceTraining": true,
    "serviceDentist": true,
    "serviceVet": true,
    "serviceMonitoring": true,
    "dogsAcepted": true,
    "catsAcepted": true,
    "othersAcepted": true,
    "averagePrice": "Até R$ 200,00",
    "guestsNumber": 31,
    "hotel": {
      "hotelId": 6
    }
  }
}
```