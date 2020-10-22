## 📦 Install

- [Source File of Transit Accidents in America in MongoDB](https://www.dropbox.com/s/bjqugthjmkh9krt/199387_896000_compressed_US_Accidents_Dec19.csv.zip?dl=0)
- Import the Source File CSV into your local installation of MongoDB.
- MongoDB queries for formatting location data of accidents to further use of GeoSpatial Queries
```
db.getCollection("US_Accidents_Dec19").find().forEach(function(doc) {
     db.getCollection("US_Accidents_Dec19").updateOne(
        {"_id": doc._id},
        {
        "$set": {
            "location": {
                "type": "Point",
                "coordinates": [ parseFloat(doc.Start_Lng), parseFloat(doc.Start_Lat) ]
            }
        },
        "$unset": {  "Start_Lat": 1, "Start_Lng": 1 } 
     });
     print("updating" + doc._id);
    });
```
- MongoDB instructions to create Geo Indexes:
```
db.getCollection("US_Accidents_Dec19").ensureIndex({ location: "2dsphere" });
```
- Now you can execute this project!

## 🚀 Usage

If you executed this app via IntelliJ or other IDE for Java you can watch [the published API documentation](https://documenter.getpostman.com/view/3340704/TVYDdyt9) to know which endpoints you can use.

### Run The Tests
If you are a developer new to this project always run the tests before you start coding!

If you are going to check in some new code never forget to add tests along with the commit that test the functionality, otherwise it will be rejected.

### Author

👤 **Fermin Minetto**
- Github: [@ferminmine](https://github.com/ferminmine)
- Mail: [fermin.minetto@gmail.com](fermin.minetto@gmail.com)

### Show your support

Please ⭐️ this repository if you found this project interesting!