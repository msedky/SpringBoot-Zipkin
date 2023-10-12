db.createUser(
        {
            user: "citz",
            pwd: "citz",
            roles: [
                {
                    role: "readWrite",
                    db: "citizens-db"
                }
            ]
        }
);

db.createCollection("citizens");

db.citizens.insert([
{
  "_id":"19880616FA8P7",
  "fname":"John",
  "secondName":"Luke",
  "thirdName":"Dudo",
  "fourthName":"Ken",
  "gender":"MALE",
  "birthDate":"1988-06-16",
  "address":"9th Richard Avenue, Boston, Texas"
},
{
  "_id":"19961205FA91C",
  "fname":"Stewart",
  "secondName":"Downing",
  "thirdName":"David",
  "fourthName":"Downing",
  "gender":"MALE",
  "birthDate":"1996-12-05",
  "address":"11th Richard Avenue, Boston, Texas"
},
{
  "_id":"19990127DDKRF",
  "fname":"Fatma",
  "secondName":"Mohammad",
  "thirdName":"AbdelSalam",
  "fourthName":"Gamal",
  "gender":"FEMALE",
  "birthDate":"1999-01-27",
  "address":"1st Wall Street, NewYork"
},
{
  "_id":"19721126TZ8SZ",
  "fname":"Zizi",
  "secondName":"Kumar",
  "thirdName":"Hamit",
  "fourthName":"Ishtar",
  "gender":"FEMALE",
  "birthDate":"1972-11-26",
  "address":"1st Wall Street, NewYork"
},
{
  "_id":"19721126BT890",
  "fname":"Alice",
  "secondName":"Johns",
  "thirdName":"Michael",
  "fourthName":"Keller",
  "gender":"FEMALE",
  "birthDate":"1972-11-26",
  "address":"55th Yoshi Street, North Carolina"
},
{
  "_id":"19950404SG7UG",
  "fname":"Yuda",
  "secondName":"Joshwa",
  "thirdName":"Yakov",
  "fourthName":"Allen",
  "gender":"MALE",
  "birthDate":"1995-04-04",
  "address":"9th Richard Avenue, Boston, Texas"
}
]
);