package exception

class CarNameLengthException(carName: String) :
    RacingCarException(String.format("[ERROR] 자동차 이름 길이 에러입니다. carName={%s}", carName))