package com.tc.requestBody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Bookingdates{
    public String checkin;
    public String checkout;
}
