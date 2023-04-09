package za.ac.cput.domain;

import java.util.Date;

public class Booking {
    private String bookingId;
    private Date date;
    private String time;
    private String address;

    public Booking(String bookingId, Date date, String time, String address) {
        this.bookingId = bookingId;
        this.date = date;
        this.time = time;
        this.address = address;
    }

    public Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.date = builder.date;
        this.time = builder.time;
        this.address = builder.address;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        private String bookingId;
        private Date date;
        private String time;
        private String address;

        public Builder setBookingId(String bookingId){
            this.bookingId = bookingId;
            return this;
        }

        public Builder setDate(Date date){
            this.date = date;
            return this;
        }

        public Builder setTime(String time){
            this.time = time;
            return this;
        }

        public Builder setAddress(String Address){
            this.address = address;
            return this;
        }

        public Builder copy(Booking booking){
            this.bookingId = booking.bookingId;
            this.date = booking.date;
            this.time = booking.time;
            this.address = booking.address;
            return null;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
