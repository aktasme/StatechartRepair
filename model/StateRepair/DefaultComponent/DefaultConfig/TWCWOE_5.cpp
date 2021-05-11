/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TWCWOE_5.h"
//## event evBC()
#include "Default.h"
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_5
TWCWOE_5::TWCWOE_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TWCWOE_5::~TWCWOE_5() {
}

unsigned int TWCWOE_5::getX() const {
    return x;
}

void TWCWOE_5::setX(unsigned int p_x) {
    x = p_x;
}

unsigned int TWCWOE_5::getY() const {
    return y;
}

void TWCWOE_5::setY(unsigned int p_y) {
    y = p_y;
}

bool TWCWOE_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TWCWOE_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    D_subState = OMNonState;
}

void TWCWOE_5::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus TWCWOE_5::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    pushNullTransition();
                    A_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evBD_Default_id))
                {
                    D_entDef();
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 3 
                    if(x != y)
                        {
                            popNullTransition();
                            A_subState = D;
                            pushNullTransition();
                            D_subState = F;
                            rootState_active = F;
                            res = eventConsumed;
                        }
                }
            
            
        }
        break;
        // State F
        case F:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 5 
                    if(x == y)
                        {
                            popNullTransition();
                            D_subState = E;
                            rootState_active = E;
                            res = eventConsumed;
                        }
                }
            
            
        }
        break;
        default:
            break;
    }
    return res;
}

void TWCWOE_5::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void TWCWOE_5::D_entDef() {
    A_subState = D;
    D_subState = E;
    rootState_active = E;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_5.cpp
*********************************************************************/
