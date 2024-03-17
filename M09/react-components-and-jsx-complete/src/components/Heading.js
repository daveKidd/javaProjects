import SubHeading from './SubHeading';

function Heading(props) {
    return (
        <div>
            <h2>{props.text}</h2>
            <SubHeading text={props.text} />
        </div>
    );
}

export default Heading;
