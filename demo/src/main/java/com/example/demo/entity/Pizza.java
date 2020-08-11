package com.example.demo.entity;

public class Pizza {
    private PizzaStatus status;

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDelivery() {
        System.out.println("Time to delivery is " + this.status.getTimeToDelivery());
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrder() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

        public boolean isOrder() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }
    }
}
