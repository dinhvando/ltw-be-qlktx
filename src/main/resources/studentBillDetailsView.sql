CREATE VIEW view_student_bill_detail
AS
select billTable.studentID,  billTable.studentName, billTable.roomName, billTable.priceRoom , billTable.priceFood,billTable.priceLaundry,(billTable.priceWaterAll/billTable.people) as priceWater, (billTable.priceElecALL/billTable.people) as priceElec, (billTable.priceRoom+billTable.priceFood+billTable.priceLaundry+(billTable.priceWaterAll+billTable.priceElecALL)/billTable.people) as total ,billTable.time
from ( select student.studentid as studentID, student.name as studentName, room.name as roomName, room.priceRoom, (foodservice.totalDay*food.price) as priceFood , laundryservice.price as priceLaundry, (waterservice.price * waterservice.numberWater) as priceWaterAll, (electricservice.price*electricservice.numberElec) as priceElecALL , bill.time as time , peopleInRoom.people as people
       from student,  room,  food, foodservice, waterservice, laundryservice, electricservice, bill,
           (select distinct bill.roomID as roomID, bill.time as time, count(roomID) as people
           from bill group by bill.roomID, bill.time) as peopleInRoom
       where student.studentID = bill.studentID
         and room.id = bill.roomID and waterservice.id = bill.waterSvID and electricservice.id = bill.elecSvID and laundryservice.id = bill.laundrySvID and foodservice.id = bill.foodSvID and food.id = foodservice.foodID and peopleInRoom.roomID = bill.roomID and peopleInRoom.time = bill.time
     ) as billTable