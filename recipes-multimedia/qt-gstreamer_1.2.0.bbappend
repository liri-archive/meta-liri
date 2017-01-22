#
# HACK: Prevent QA issue due to the fact that upstream
# package apparently has OE_QMAKE_PATH_QML=/usr/lib/qml and
# OE_QMAKE_PATH_IMPORTS=/usr/lib/imports
#
FILES_${PN}_append = " \
    /usr/lib/qt5/qml \
    /usr/lib/qt5/imports \
"
