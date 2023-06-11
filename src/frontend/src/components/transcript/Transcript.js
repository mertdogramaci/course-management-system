import React from 'react';
import { Document, Text, Page, StyleSheet, View, Image, Font, Svg, Line } from '@react-pdf/renderer';
import { Table } from 'reactstrap';

Font.register({
    family: "Roboto",
    fonts: [
        { src: "https://cdnjs.cloudflare.com/ajax/libs/ink/3.1.10/fonts/Roboto/roboto-light-webfont.ttf", fontWeight: 300 },
        { src: "https://cdnjs.cloudflare.com/ajax/libs/ink/3.1.10/fonts/Roboto/roboto-regular-webfont.ttf", fontWeight: 400 },
        { src: "https://cdnjs.cloudflare.com/ajax/libs/ink/3.1.10/fonts/Roboto/roboto-medium-webfont.ttf", fontWeight: 500 },
        { src: "https://cdnjs.cloudflare.com/ajax/libs/ink/3.1.10/fonts/Roboto/roboto-bold-webfont.ttf", fontWeight: 600 },
    ],
})

const styles = StyleSheet.create({
    image: {
        height: '8vh',
        width: '8vw',
    },
    text: {
        fontFamily: "Roboto",
        fontSize: 10
    },
    row: {
        flexDirection: 'row',
        marginBottom: 10
    },
    page: {
        margin: 20
    }
});

const Transcript = (props) => (
    <Document>
        <Page size="A4" style={styles.page}>
            <Line style={styles.row}>
                <Image style={styles.image} src='https://upload.wikimedia.org/wikipedia/tr/thumb/2/28/Hacettepe_%C3%9Cniversitesi_Logosu.svg/1200px-Hacettepe_%C3%9Cniversitesi_Logosu.svg.png'></Image>
                <center>
                    <Text style={styles.text}>T.C.</Text>
                    <Text style={styles.text}>Hacettepe Üniversitesi</Text>
                    <Text style={styles.text}>Öğrenci İşleri Daire Başkanlığı</Text>
                    <Text style={styles.text}>Not Durum Belgesi</Text>
                    <Text style={styles.text}>(Transkript)</Text>
                </center>
            </Line>

            <Svg height="10" width="560">
                <Line x1="0" y1="1" x2="50000000" y2="2" strokeWidth={1} stroke="rgb(0,0,0)" />
            </Svg>

            <Table>
                <tableRow style={styles.tableRow}>
                    <tableCell>Öğrenci Numarası:</tableCell>
                </tableRow>
            </Table>
        </Page>
    </Document>
);

export default Transcript;