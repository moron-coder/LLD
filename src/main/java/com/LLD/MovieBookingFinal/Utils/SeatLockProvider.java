package com.LLD.MovieBookingFinal.Utils;

import com.LLD.MovieBookingFinal.Entity.Schedule;
import com.LLD.MovieBookingFinal.Entity.Seat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SeatLockProvider {
    private final HashMap<String, Long> seatExpirations;
    private static final int SEAT_LOCKING_TIME_IN_MINUTES = 15;

    private static SeatLockProvider instance;
    private SeatLockProvider(){
        seatExpirations = new HashMap<>();
    };
    public synchronized static SeatLockProvider getInstance(){
        if(instance==null){
            instance = new SeatLockProvider();
        }
        return instance;
    }

   public Set<Seat> excludeLockedSeats(Schedule schedule, Set<Seat> seats){
        Long currentTime = Calendar.getInstance().getTimeInMillis();
        Set<Seat> availableSeats = new HashSet<>();
        for(Seat seat : seats){
            String key = getLockingKey(schedule.getId(), seat.getId());
            if(!seatExpirations.containsKey(key) || seatExpirations.get(key)<=currentTime){
                //  unlocked
                availableSeats.add(seat);
            }
        }
        return availableSeats;
   }

   private String getLockingKey(String scheduleId, String seatId){
        return scheduleId+"-"+seatId;
   }

    private HashSet<String> generateLockingKeys(Schedule schedule, Set<Seat> seats){
        HashSet<String> keys = new HashSet<>();
        for(Seat seat : seats){
            keys.add(getLockingKey(schedule.getId(), seat.getId()));
        }
        return keys;
    }

    public void lockPermanentBookedSeats(Schedule schedule, Set<Seat> seats){
        HashSet<String> keys = generateLockingKeys(schedule, seats);
        Long newExpirationTime = schedule.getEndTime().getTime();
        for(String key : keys){
            seatExpirations.put(key, newExpirationTime);
        }
    }

    public void takeLock(Schedule schedule, Set<Seat> seats){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, SEAT_LOCKING_TIME_IN_MINUTES);
        Long expirationTime = c.getTimeInMillis();
        HashSet<String> keys = generateLockingKeys(schedule, seats);
        for(String key : keys){
            seatExpirations.put(key, expirationTime);
        }
    }

    public void unlock(Schedule schedule, Set<Seat> seats){
        //  for failed payment or when scheduler clears old bookings
        HashSet<String> keys = generateLockingKeys(schedule, seats);
        for(String key : keys){
            seatExpirations.remove(key);
        }
    }

    public synchronized boolean takeLockIfAllowed(Schedule schedule, Set<Seat> seats){
        long currentTimeMillis = Calendar.getInstance().getTimeInMillis();
        HashSet<String> keys = generateLockingKeys(schedule, seats);
        for(String key : keys){
            Long expirationTime = seatExpirations.get(key);
            if(expirationTime!=null){
                if(expirationTime<=currentTimeMillis) {
                    seatExpirations.remove(key);
                }else{
                    return false;
                }
            }
        }
        takeLock(schedule, seats);
        return true;
    }
}
