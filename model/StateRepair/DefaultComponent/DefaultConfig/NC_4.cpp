/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_4
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "NC_4.h"
//## event evA()
#include "Default.h"
//## package _6_NestedConditions

//## class NC_4
NC_4::NC_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

NC_4::~NC_4() {
}

int NC_4::getX() const {
    return x;
}

void NC_4::setX(int p_x) {
    x = p_x;
}

bool NC_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void NC_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void NC_4::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus NC_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State A
    if(rootState_active == A)
        {
            if(IS_EVENT_TYPE_OF(evA_Default_id))
                {
                    //## transition 2 
                    if(x == 1)
                        {
                            rootState_subState = B;
                            rootState_active = B;
                            res = eventConsumed;
                        }
                    else
                        {
                            //## transition 4 
                            if(x == 2)
                                {
                                    rootState_subState = C;
                                    rootState_active = C;
                                    res = eventConsumed;
                                }
                            else
                                {
                                    rootState_subState = D;
                                    rootState_active = D;
                                    res = eventConsumed;
                                }
                        }
                }
            
        }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_4.cpp
*********************************************************************/
