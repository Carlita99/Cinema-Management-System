/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemamanagementsystem.Mapper;

import cinemamanagementsystem.Repositories.*;


public class MapperFactory {
    private static MovieModelMapper movieModelMapper = null;
    private static ProjectionModelMapper projectionModelMapper = null;
    private static ReservationModelMapper reservationModelMapper = null;
    private static RoleModelMapper roleModelMapper = null;
    private static SeatModelMapper seatModelMapper = null;
    private static TheaterModelMapper theaterModelMapper = null;
    private static UserModelMapper userModelMapper = null;
    
    public static IMapper getMapper(Object o){
        if(o instanceof MovieRepository){
            if(movieModelMapper == null){
                movieModelMapper = new MovieModelMapper();
            }
            return movieModelMapper;
        }
        if(o instanceof ProjectionRepository){
            if(projectionModelMapper == null){
                projectionModelMapper = new ProjectionModelMapper();
            }
            return projectionModelMapper;
        }
        if(o instanceof ReservationRepository){
            if(reservationModelMapper == null){
                reservationModelMapper = new ReservationModelMapper();
            }
            return reservationModelMapper;
        }
        if(o instanceof RoleRepository){
            if(roleModelMapper == null){
                roleModelMapper = new RoleModelMapper();
            }
            return roleModelMapper;
        }
        if(o instanceof SeatRepository){
            if(seatModelMapper == null){
                seatModelMapper = new SeatModelMapper();
            }
            return seatModelMapper;
        }
        if(o instanceof TheaterRepository){
            if(theaterModelMapper == null){
                theaterModelMapper = new TheaterModelMapper();
            }
            return theaterModelMapper;
        }
        if(o instanceof UserRepository){
            if(userModelMapper == null){
                userModelMapper = new UserModelMapper();
            }
            return userModelMapper;
        }
        return null;
    }
}
